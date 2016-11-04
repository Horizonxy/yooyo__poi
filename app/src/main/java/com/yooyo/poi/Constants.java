package com.yooyo.poi;

public class Constants {

	public static final int PAGE_SIZE = 20;

	public static final String END_POIND = "http://gank.io";
	public static final String DOWNLOAD_POIND = "http://hengdawb-app.oss-cn-hangzhou.aliyuncs.com";

	public static final String BASE_DIR = "horizon_gank_5.0";
	public static final String IMG_CACHE_DIR = BASE_DIR.concat("/image_cache");
	public static final String IMG_WEB_CACHE_DIR = BASE_DIR.concat("/image_web");
	public static final String IMG_DOWNLOAD_DIR = BASE_DIR.concat("/download");

	public final static String BUNDLE_WEBVIEW_URL = "bundle_webview_url";
	public final static String BUNDLE_WEBVIEW_VEDIO = "bundle_webview_vedio";

	public final static String BUNDLE_PIC_INFOS = "bundle_picture_infos";

	public final static String BUNDLE_FRAGMENT_TYPE = "bundle_fragment_type";

	public final static String BUNDLE_THEME = "bundle_theme";
	public final static String BUNDLE_OLD_THEME_COLOR = "bundle_theme_color";

	public static final int REQ_PERMISSIONS = 1000;

	/** 缓存100天 */
	public static final long CACHE_TIME = 60 * 60 * 24 * 100;
	/** 10秒超时 */
	public static final long TIME_OUT = 10;
	/** 缓存容量 */
	public static final long SIZE_OF_CACHE = 100 * 1024 * 1024;


}
