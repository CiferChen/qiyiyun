package com.zhidian.server.configuration;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class StartInit implements ServletContextListener {
	static final Logger logger = Logger.getLogger(StartInit.class);

	// 系统初始化执行方法
	public void contextDestroyed(ServletContextEvent e) {
		logger.info("系统停止...");
	}

	public void contextInitialized(ServletContextEvent e) {
		logger.info("系统初始化开始...");

		// 获取项目根目录
		String root_path = e.getServletContext().getRealPath("/");
		logger.info(root_path);

		readConfigurations("/message.properties", Configuration.MESSAGES);
		readIPs();
		readConfigurations("/configuration.properties",
				Configuration.CONFIGURATIONS);
		detectInitialState();// 检测平台状态
		qyyInitailize();// 初始化平台

		// 初始化 ConfigFactorty
		// ConfigFactory.init(root_path);
		// // 初始化数据链接信息
		// DBManager.init();
		// // 初始化定时统计任务
		// TaskManager.init();
		// // 初始化用户信息查询位置
		// UserInfo.init();
		logger.info("系统初始化结束...");
	}

	/**
	 * 初始化平台
	 */
	private void qyyInitailize() {
		logger.info("平台初始化");
	}

	/**
	 * 检测平台状态
	 */
	private void detectInitialState() {
		logger.info("检测平台状态");
	}

	private void readConfigurations(String path, int ConfigurationType) {
		logger.info("读取配置信息");
		Properties p = new Properties();
		InputStream inputStream = StartInit.class.getResourceAsStream(path);
		try {
			p.load(inputStream);
			switch (ConfigurationType) {
			case Configuration.CONFIGURATIONS:
				Set<Entry<Object, Object>> entryConfigurationSet = p.entrySet();
				for (Entry<Object, Object> entry : entryConfigurationSet) {
					if (!entry.getKey().toString().startsWith("#")) {
						Configuration.configurations.put(
								((String) entry.getKey()).trim(),
								((String) entry.getValue()).trim());
					}
				}
				break;
			case Configuration.MESSAGES:
				Set<Entry<Object, Object>> entryMessageSet = p.entrySet();
				for (Entry<Object, Object> entry : entryMessageSet) {
					if (!entry.getKey().toString().startsWith("#")) {
						Configuration.messages.put(
								((String) entry.getKey()).trim(),
								((String) entry.getValue()).trim());
					}
				}
				break;
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readIPs() {
		logger.info("读取IP");
		Properties p = new Properties();
		InputStream inputStream = StartInit.class
				.getResourceAsStream("/ip.properties");
		try {
			p.load(inputStream);
			Iterator<?> iterator = p.values().iterator();
			while (iterator.hasNext()) {
				Configuration.ips.add((String) iterator.next());
			}
			inputStream.close();
		} catch (Exception e) {
		}
	}
}
