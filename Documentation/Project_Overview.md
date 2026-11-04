# Project Overview

## Objective
Integrate SAP SuccessFactors employee master data with a downstream application using SAP Integration Suite as the middleware layer.

## Business context
A downstream application needs selected employee attributes maintained in SuccessFactors. CPI separates source access, transformation, routing and target communication, reducing direct coupling between the systems.

## Scope
- Receive an employee ID through an HTTPS request.
- Extract and validate the supplied ID dynamically.
- Retrieve employee data through SuccessFactors OData V2.
- Map personal and employment attributes into JSON.
- Route found and not-found results separately.
- Authenticate to FastAPI and persist successful records in PostgreSQL.
- Validate positive and negative scenarios.

Out of scope: scheduled replication, bulk synchronization, production rollout, high availability and disaster recovery.

## Systems
| System | Responsibility |
|---|---|
| Postman | Sends test requests |
| SAP Integration Suite | Orchestrates the integration |
| SAP SuccessFactors | Source of employee data |
| FastAPI | Target REST service |
| PostgreSQL | Persistence |
| pgAdmin | Database verification |

## Target data contract
The JSON contract contains `person_id_external`, `first_name`, `last_name`, `user_id`, `start_date` and `end_date`. An absent end date is represented as JSON `null`.

## Success criteria
1. A valid ID retrieves the expected source record.
2. CPI transforms the response into the target JSON structure.
3. FastAPI accepts the authenticated request.
4. The record is visible in PostgreSQL.
5. An invalid ID follows the not-found route.
6. Missing input is handled.
7. Different IDs can be processed without changing the iFlow design.

The project author reports that these scenarios have been tested. See [Testing and Results](Testing_and_Results.md).
