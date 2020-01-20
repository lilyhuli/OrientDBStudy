package cn.lilyhuli.config;

import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.orientechnologies.orient.core.config.OGlobalConfiguration.*;
import static cn.lilyhuli.constants.GlobalConstants.*;


/**
 * @author tangd-a
 * @date 2020/1/20 14:03
 */

@Configuration
public class OrientDbConfig {


	@Bean
	public ODatabasePool oDatabasePool() {
		Map<String, Object> params = new HashMap<>();
		params.put(DB_POOL_MIN.getKey(), 10);
		params.put(DB_POOL_MAX.getKey(), 100);
		params.put(DB_POOL_ACQUIRE_TIMEOUT.getKey(), 30000);
		params.put(DB_POOL_IDLE_TIMEOUT.getKey(), 0);
		params.put(DB_POOL_IDLE_CHECK_DELAY.getKey(), 0);
		OrientDBConfig config =  OrientDBConfig.builder().fromMap(params).build();
		return new ODatabasePool(orientDB(), DB, ADMIN, ADMIN, config);
	}

	@Bean
	public OrientDB orientDB() {
		return new OrientDB(URL, ROOT, "wyc", OrientDBConfig.defaultConfig());
	}
}
