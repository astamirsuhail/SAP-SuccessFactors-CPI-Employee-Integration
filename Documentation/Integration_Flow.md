# CPI Integration Flow

| Component | Responsibility |
|---|---|
| HTTPS Sender | Receives the incoming request |
| Content Modifier | Prepares message context |
| `ExtractEmployeeID` | Extracts `employeeId` from `CamelHttpQuery` |
| Router | Separates missing ID from valid input |
| SuccessFactors Request Reply | Executes the OData V2 lookup |
| Router | Separates employee-found and employee-not-found paths |
| Prepare Employee Data | Extracts XML values and constructs JSON |
| `RetrieveFastAPIKey` | Retrieves the API key from Secure Parameter storage |
| HTTP Receiver | POSTs JSON to FastAPI |

The iFlow references the Secure Parameter by alias only. Do not hardcode the secret in a Content Modifier or script.
