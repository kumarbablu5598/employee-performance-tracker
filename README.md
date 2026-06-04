# System design notes — Employee Performance Tracker

This short write-up describes how to scale the system for heavy reporting and what to do if the
GET /cycles/{id}/summary query becomes slow for large cycles. (<= 400 words)

Checklist
- Create `README.md` with system-design summary
- Describe scaling for 500 concurrent managers
- Explain fixes for slow /cycles/{id}/summary at 100k+ reviews
- Describe caching locations and contents

Scaling to support 500 concurrent managers running reports
- Run multiple stateless application instances behind a load balancer (ALB/Nginx). Scale horizontally
  (Kubernetes HPA or autoscaling groups) and use an API gateway for rate limiting and authentication.
- Move heavy work off request path: implement asynchronous report generation. Requests enqueue a job
  (Kafka/RabbitMQ) and return a job id; workers compute reports and store results in Redis or object
  storage (S3) for retrieval. This avoids blocking threads and reduces database load.
- Use a connection pool (HikariCP) tuned to DB capacity, and isolate reporting DB workload to read replicas.

If GET /cycles/{id}/summary gets slow at 100k+ reviews
- Add proper indexes (e.g. on `performance_reviews.review_cycle_id`, `employee_id`) and avoid N+1 queries.
- Replace on-the-fly aggregation with precomputed aggregates: maintain a denormalized summary table or
  materialized view updated incrementally by review-create/update events (via DB triggers or async worker).
- Offload heavy aggregations to read-replicas or OLAP store (ClickHouse, Redshift) for analytical queries.
- Implement pagination/streaming and limit unbounded result sets; use SQL window functions and efficient
  grouping queries rather than fetching all rows into memory.

Where to add caching, and what to cache
- Cache the computed cycle summary in Redis keyed by `cycle:summary:{id}` with TTL and event-driven
  invalidation when reviews are added/updated. For near-real-time metrics use atomic increments in Redis
  to update counters as reviews arrive, and periodically reconcile with the DB.
- Cache relatively static lookups (employee profiles) in an application-side cache or Redis.
- Cache query plans or precomputed report files (JSON/CSV) in object storage and serve via CDN for repeated downloads.

Notes on consistency and invalidation
- Prefer event-driven invalidation (publish review-created/updated events) so caches are updated
  immediately or marked stale; for strong consistency fall back to short TTLs and background refresh.
