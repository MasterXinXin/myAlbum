package cn.com.zhang.album;

/**
 * @author czm 2020/1/6.
 */
public enum MinaServerMsg {

    DRIVEN_ENGINE {
        @Override
        public String getLocation() {
            return "127.0.0.1:8090";
        }

        @Override
        public String getName() {
            return "event_driven";
        }
    };

    public abstract String getLocation();

    public abstract String getName();
}
