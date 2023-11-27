package org.herosquad.utils;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;


public class SparkUtils {
    public static Map<String, Object> createModel() {
        return new HashMap<>();
    }

    public static class FreeMarkerTemplateEngine extends FreeMarkerEngine {
        public FreeMarkerTemplateEngine() {
            setConfiguration(createFreemarkerConfig());
        }
    }

    private static Configuration createFreemarkerConfig() {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(SparkUtils.class, "/templates/");
        return config;
    }
}