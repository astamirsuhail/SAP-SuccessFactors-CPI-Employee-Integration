# Testing and Results

The following scenarios were tested in the learning environment.

| Scenario | Expected behaviour | Result |
|---|---|---|
| Valid employee ID | Retrieve source data, call FastAPI, persist record | Passed |
| Different valid IDs | Use the supplied ID dynamically | Passed |
| Invalid employee ID | Return employee-not-found response | Passed |
| Missing employee ID | Return input-validation response | Passed |
| Database verification | Confirm rows in PostgreSQL | Passed |

## Database verification

```sql
SELECT id, person_id_external, first_name, last_name,
       user_id, start_date, end_date
FROM public.employees
ORDER BY id;
```

Add sanitized screenshots showing the iFlow, Postman test results, and database verification. Review screenshots for credentials, API keys, tenant identifiers, employee personal data, and confidential information before publishing.
