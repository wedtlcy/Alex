package elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * <P>Elasticsearch索引的创建、数据的增删该查操作</P>
 *
 * <herf>https://www.cnblogs.com/sunny1009/articles/7887568.html</herf>
 * @author chuanyin.li
 * @create 2019-01-25 10:41
 **/
public class ElasticSearchCRUD {

    private Logger logger = LoggerFactory.getLogger(ElasticSearchCRUD.class);

    public static final String HOST = "10.18.6.22";
    /**
    * http请求的端口是9200，客户端是9300
    */
    public static final int PORT = 9300;

    private static TransportClient client = null;

    /**
    * @Description: 获取客户端连接信息
    * @Param: []
    * @return: void
    * @Author: chuanyin.li
    * @Date: 1/25/2019
    */
    @SuppressWarnings({ "resource", "unchecked" })
    @Before
    public void getConnect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                new TransportAddress(InetAddress.getByName(HOST),PORT));
        logger.info("连接信息:" + client.toString());
    }

    /**
    * @Description: 关闭连接
    * @Param: []
    * @return: void
    * @Author: chuanyin.li
    * @Date: 1/25/2019
    */
    @After
    public void closeConnect() {
        if(null != client) {
            logger.info("执行关闭连接操作...");
            client.close();
        }
    }

}
