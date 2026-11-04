import com.sap.gateway.ip.core.customdev.util.Message
import com.sap.it.api.ITApiFactory
import com.sap.it.api.securestore.SecureStoreService

def Message processData(Message message) {

    def alias = message.getProperty("ApiKeyAlias")

    def secureStoreService =
        ITApiFactory.getService(SecureStoreService.class, null)

    if (secureStoreService == null || !alias) {
        throw new Exception("Secure Store service or API key alias unavailable")
    }

    try {
        def credential = secureStoreService.getUserCredential(alias)

        if (credential == null || !credential.getPassword()) {
            throw new Exception("API key unavailable")
        }

        def apiKey = credential.getPassword().toString()

        message.setHeader("X-API-Key", apiKey)

    } catch (Exception e) {
        throw new Exception(
            "Unable to retrieve FastAPI API key from Security Material"
        )
    }

    return message
}
