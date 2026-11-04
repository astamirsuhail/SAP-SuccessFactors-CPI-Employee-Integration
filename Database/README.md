# PostgreSQL Database

## Database Details

Database name: successfactors_db

Schema: public

Table: employees

## Table Structure

| Column | Description |
|---|---|
| id | Primary key |
| person_id_external | SuccessFactors external person ID |
| first_name | Employee first name |
| last_name | Employee last name |
| user_id | SuccessFactors user ID |
| start_date | Employment start date |
| end_date | Employment end date |

## Verification Query

```sql
SELECT
    id,
    person_id_external,
    first_name,
    last_name,
    user_id,
    start_date,
    end_date
FROM public.employees
ORDER BY id ASC;
