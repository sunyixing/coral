package com.coral.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成工具
 * @ClassName TestGenerator
 * @Author sunyixing
 * @Date 2019-08-21 18:58
 * @Version 1.0
 *
 */
public class SyxGenerator {

    //一级目录名
    public static final String FIRST_FILE_PATH = "business";

    //填写项目名称
    public static final String FILE_PATH = "coral-business-start-helper";

    //设置包名
    public static final String PACKAGE_NAME = "com.coral.business";

    //作者
    public static final String AUTHOR = "sunyixing";

    //设置数据库地址
    public static final String  DATABASE_PATH= "192.168.2.28:5127";

    //设置数据库名称
    public static final String DATABASE_NAME = "coral";

    //数据库用户名
    public static final String DATABASE_USER_NAME = "root";

    //数据库密码
    public static final String DATABASE_PASSWORD = "123456";

    //设置表名前缀
    public static final String TABLE_PREFIX = "cr_";

    //生成数据库的表
    public static final String TABLE = "cr_user";



    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/"+FIRST_FILE_PATH+"/" + FILE_PATH + "/src/main/java");
        gc.setAuthor( AUTHOR ); //设置作者名称
        gc.setOpen(false); //是否默认生成文件
        gc.setFileOverride(true); //是否生成已有文件
        gc.setDateType(DateType.ONLY_DATE);
        //gc.setSwagger2(true);					//开启 swagger2 模式 默认false
        gc.setBaseColumnList(true);				//开启 baseColumnList 默认false
        gc.setBaseResultMap(true);				//开启 BaseResultMap 默认false
        //gc.setEntityName("%sEntity");			//实体命名方式  默认值：null 例如：%sEntity 生成 UserEntity
        gc.setMapperName("%sMapper");			//mapper 命名方式 默认值：null 例如：%sDao 生成 UserDao
        gc.setXmlName("%sMapper");				//Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
        gc.setServiceName("I%sService");			//repository 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceImplName("%sServiceImpl");	//repository impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setControllerName("%sController");	//controller 命名方式    默认值：null 例如：%sAction 生成 UserAction

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://" + DATABASE_PATH + "/"+ DATABASE_NAME +"?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername( DATABASE_USER_NAME );
        dsc.setPassword( DATABASE_PASSWORD );
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("");
        pc.setParent(PACKAGE_NAME);
        //.setMapper("mapper")//dao
        //.setService("repository")//servcie
        //.setController("controller")//controller
        //.setEntity("entity")
        //.setXml("mapper");//mapper.xml

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/"+FIRST_FILE_PATH+"/" + FILE_PATH + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null).setController(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 数据库字段下划线转驼峰命令策略
        //strategy.setCapitalMode(true); //全局大写设置
        //strategy.setSuperEntityClass("com.xxy.BaseEntity"); //自定义继承的Entity类全称，带包名
        strategy.setEntityLombokModel(true);//设置是否使用lombok
        //strategy.setSuperControllerClass("com.xxy.BaseController");
        strategy.setRestControllerStyle(true); //生成 @RestController 控制器
        //设置生成的表
        strategy.setInclude(new String[]{TABLE});
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(TABLE_PREFIX);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
