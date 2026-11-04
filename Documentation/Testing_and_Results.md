# Testing and Results

## Test approach
Postman was used to invoke the CPI HTTPS endpoint. pgAdmin was used to inspect the PostgreSQL table after successful processing.

## Test summary
| Test ID | Scenario | Input | Reported result |
|---|---|---|---|
| TC-01 | Valid employee | Employee ID present in SuccessFactors | Successful processing; record verified in PostgreSQL |
| TC-02 | Invalid employee | Deliberately non-existent employee ID | CPI returned the configured `NOT_FOUND` response |
| TC-03 | Missing employee ID | Request without the required query parameter | Missing-input scenario tested and handled |
| TC-04 | Dynamic employee ID | Different valid employee IDs | Same iFlow processed different IDs; resulting records verified in PostgreSQL |

## Example not-found response
```xml
<EmployeeResponse>
  <Status>NOT_FOUND</Status>
  <Message>No employee found for the requested Employee ID.</Message>
</EmployeeResponse>
```

## Database verification query
```sql
SELECT
    id, person_id_external, first_name, last_name,
    user_id, start_date, end_date
FROM public.employees
ORDER BY id;
```

## Recommended evidence
Add sanitized screenshots to `Screenshots/`:
1. CPI iFlow overview.
2. Successful Postman request.
3. Invalid employee response.
4. Missing employee ID test.
5. Request using a different valid employee ID.
6. pgAdmin database verification.

Mask API keys, authorization headers, OAuth secrets, sensitive tenant URLs, email addresses and real employee personal information. Prefer fictitious test data.

## Result
The project author reports successful completion of the valid, invalid, missing-input and dynamic employee ID tests, including database verification. These are portfolio tests in a learning/demo environment, not evidence of a production deployment.
