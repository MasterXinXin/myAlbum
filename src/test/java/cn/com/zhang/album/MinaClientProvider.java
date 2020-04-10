package cn.com.zhang.album;

import com.asiainfo.appserver.ClientConfiguration;
import com.asiainfo.appserver.MinaAppClient;

import java.util.HashMap;
import java.util.Map;


public class MinaClientProvider {

    private final static Map<String, MinaAppClient> CLIENTS = new HashMap<String, MinaAppClient>();

    public synchronized static MinaAppClient getClient(MinaServerMsg mina) {
        MinaAppClient client = CLIENTS.get(mina.getName());
        if (client == null) {
            ClientConfiguration configuration = new ClientConfiguration();
            configuration.setServerAddressesString(mina.getLocation());
            configuration.setMaxConnectionsPerServer(10000);
            configuration.setSocketConnTimeoutSec(5);
            //configuration.setSocketDataTimeoutSec(2);
            client = new MinaAppClient(configuration);
            CLIENTS.put(mina.getName(), client);
        }
        return client;
    }

}
