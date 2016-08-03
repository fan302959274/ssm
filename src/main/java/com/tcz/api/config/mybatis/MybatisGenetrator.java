/**
 * 
 */
package com.tcz.api.config.mybatis;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * mybatis代码自动生成
 * 
 * @author cf 2016年7月25日上午10:48:13
 */
public class MybatisGenetrator {
	Logger logger = Logger.getLogger(MybatisGenetrator.class);

	/**
	 * * 测试 * @throws XMLParserException * @throws IOException * @throws
	 * InvalidConfigurationException * @throws InterruptedException * @throws
	 * SQLException
	 */
	// @Test
	public void testGenerate() throws IOException, XMLParserException, InvalidConfigurationException, SQLException,
			InterruptedException {
		String pathSptor = System.getProperty("path.separator");
		String filePath = System.getProperty("java.class.path");
		filePath = filePath.substring(0, filePath.indexOf(pathSptor)) + File.separator + "generatorConfig.xml";
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		logger.info(filePath);
		File configFile = new File(filePath);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String w : warnings)
			logger.info(w);
	}

	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException,
			SQLException, InterruptedException {
		new MybatisGenetrator().testGenerate();
	}
}
