package script

import com.sap.gateway.ip.core.customdev.util.Message
import java.net.URLDecoder

def Message processData(Message message) {

    def headers = message.getHeaders()
    def query = headers.get("CamelHttpQuery")

    String employeeId = null

    if (query != null && !query.trim().isEmpty()) {

        def params = query.split("&").collectEntries { param ->
            def parts = param.split("=", 2)

            [
                URLDecoder.decode(parts[0], "UTF-8"),
                parts.length > 1
                    ? URLDecoder.decode(parts[1], "UTF-8")
                    : ""
            ]
        }

        employeeId = params.get("employeeId")
    }

    if (employeeId == null || employeeId.trim().isEmpty()) {

        message.setProperty("InputValidationError", "true")
        message.setProperty("EmployeeID", "")

    } else {

        message.setProperty("InputValidationError", "false")
        message.setProperty("EmployeeID", employeeId.trim())
    }

    return message
}
