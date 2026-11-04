# Testing and Results

## 1. Testing Objective

To verify dynamic employee ID processing, SuccessFactors data retrieval, conditional routing, JSON transformation, FastAPI communication and PostgreSQL persistence.

## 2. Test Cases

| Test Case | Input | Expected Result | Observed Result |
|---|---|---|---|
| Valid employee | Existing employee ID | Employee data retrieved and processed | Successful |
| Different valid employee | Another existing employee ID | Corresponding employee data processed | Successful |
| Invalid employee | Non-existing employee ID | NOT_FOUND response | Successful |
| Missing employee ID | Parameter omitted | Input validation response | Successful |
| Dynamic input | Employee ID changed between requests | Flow processes the supplied ID | Successful |

## 3. Database Verification

The PostgreSQL table used for verification is:

public.employees

The following query was used:

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
