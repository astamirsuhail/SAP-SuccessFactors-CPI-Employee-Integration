# Interview Preparation

## 60-second explanation
I built a learning project using SAP Integration Suite to integrate SAP SuccessFactors employee master data with an external FastAPI application backed by PostgreSQL. A request enters CPI through an HTTPS sender with a dynamic employee ID. A Groovy script extracts the ID, and CPI uses it in a SuccessFactors OData V2 query. The response is XML, so I use XPath-based extraction and a Content Modifier to construct a normalized JSON payload. Before calling the target API, CPI retrieves an API key from BTP Security Material and sends the payload through HTTP POST. I implemented routing for missing and invalid employee IDs and verified that valid employee records were persisted in PostgreSQL.

## Questions to prepare
1. Why use CPI between SuccessFactors and FastAPI?
2. What is an iFlow?
3. Difference between sender and receiver adapters?
4. What is OData V2?
5. Why use `PerPerson` with navigation properties?
6. Explain `$select`, `$expand`, and `$filter`.
7. Why use Groovy to extract a dynamic employee ID?
8. What is `CamelHttpQuery`?
9. Difference between exchange property and message header?
10. What does a Content Modifier do?
11. What is XPath?
12. Why transform XML into JSON?
13. How does a Router work?
14. How did you handle missing and invalid IDs?
15. Difference between HTTP GET and POST?
16. How does CPI authenticate to FastAPI?
17. Why use a Secure Parameter?
18. What does FastAPI do?
19. How did you verify PostgreSQL persistence?
20. What would you improve before production?

Describe this as a personal learning/portfolio implementation, not a commercial or company production integration. Do not claim production-grade monitoring, high availability, or scheduled replication unless implemented and verified.
