# PostgreSQL Database

## Purpose
PostgreSQL stores employee records received by the FastAPI target application.

## Database objects
- Database: `successfactors_db`
- Schema: `public`
- Table: `employees`

## Table columns
| Column | Type shown/expected | Purpose |
|---|---|---|
| `id` | Integer, primary key | Internal database identifier |
| `person_id_external` | Character varying | External employee/person identifier |
| `first_name` | Character varying | First name |
| `last_name` | Character varying | Last name |
| `user_id` | Character varying | SuccessFactors user ID |
| `start_date` | Date | Employment start date |
| `end_date` | Date, nullable | Employment end date |

## Illustrative schema
Review this against the existing database before running it. It is documentation, not an instruction to overwrite an existing table.

```sql
CREATE TABLE IF NOT EXISTS public.employees (
    id SERIAL PRIMARY KEY,
    person_id_external VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(150),
    last_name VARCHAR(150),
    user_id VARCHAR(100),
    start_date DATE,
    end_date DATE
);
```

## Verification
```sql
SELECT
    id, person_id_external, first_name, last_name,
    user_id, start_date, end_date
FROM public.employees
ORDER BY id;
```

Database connection settings must be provided through local environment configuration. Never commit passwords, credential-bearing connection strings or production data.
