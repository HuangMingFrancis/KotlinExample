package com.francis.kotlinexample.base

import android.net.Uri

/**
 * @author: Felix Shi
 * *
 * @date: 2015/8/14 21:46
 * *
 * @Description: 常量
 */
object Constants {

    val SHIPPER = "2"
    val DRIVER = "3"

    val SERVER_RETURN_SUCCESS = "1"
    val SERVER_RETURN_FAIL = "0"

    val SPIT = "#@@#"
    val SPIT_RIGHT = "RIG#HT"

    val INFO_REFRESH_MILLS = 10 * 60 * 1000
    val ACTION_REFRESH = "com.mamsf.gy.ACTION_REFRESH"

    val IMAG_SCAL = 0.7

    // SplashActivity
    val GO_MAIN_ACTIVITY = 1
    val GO_LOGIN_ACTIVITY = 2
    val GO_GUIDE_ACTIVITY = 3
    val GET_GUIDE_PIC_RESULT = 4
    val SPLASH_DELAY_MILLIS: Long = 2000
    val GO_GET_CAR_DATA = 5
    val ADRESS = 100
    val CARDATA = 102
    val GET_VERSION_SUCCESS = 201

    // Login
    val LOGIN_RESULT = 100
    val REGISTER_RESULT = 101
    val REQUEST_CODE_REGISTER = 200
    val REQUEST_CODE_PICK_IMAGE = 201
    val REQUEST_CODE_CAPTURE_CAMEIA = 202
    val USER_AUTHORITY_NORMAL = "or"
    val USER_AUTHORITY_ELECRTONIC = "ec"
    val ElectronicCommerce = 8
    val MSG_REFRESH = 301
    val REQUEST_CODE_FIND_PWD_UPDATE = 401
    val SEND_VERIFY_DELAY_TIMES = 60

    // home
    val LOAD_MODULE_RESULT = 300
    val LOAD_POPUP_MODULE_RESULT = 301
    val DOWNLOAD_MODULE_PIC_FINISH = 302
    val LOAD_POPUP_MODULE_FROM_DB = 304
    val MSG_AUTO_TO_NEXT_PAGE = 305

    val MODULE_TYPE_IS_URL = "0" // 跳转到网页
    val MODULE_TYPE_IS_POPUP = "1" // 弹出
    val MODULE_TYPE_IS_CLASS = "2" // 跳转到另一个Activity
    val MODULE_TYPE_IS_COMING = "3" // 此功能即将上线
    val MODULE_TYPE_IS_APP = "4" // 跳转到另一个应用
    val MODULE_TYPE_IS_BOTTOMPOP = "5" // 底部弹出框
    val MODULE_TYPE_IS_FRAGMENT = "6" // 跳转到另一个Fragment
    val MODULE_TYPE_IS_URL_NO_TITLE = "7" // 跳转到网页（不带标题栏）
    val MODULE_TYPE_IS_DIALOG = "8" // 跳转到网页（不带标题栏）

    val MODULE_TYPE_SHOW_DIALOG = 3003

    val ACTION_IN_FROM_LEFT = 4001
    val ACTION_IN_FROM_RIGHT = 4002

    val REQUEST_CITY_FROM = 1
    val REQUEST_CITY_TO = 2

    val GET_SHOU_HUO_REN = 3
    val GET_FA_HUO_REN = 4
    val GET_GOODS = 5

    // 天气查询定位
    val LOAD_LOCATION_WEATHER = 2009

    // 工程相关常量
    object Project {
        val ProjectName = "GYMamsf"
    }

    // 路径相关常量
    object Path {
//        val AppPath = Environment
//                .getExternalStorageDirectory()
//        + File.separator
//        + Project.ProjectName
//        val SharedPreferencesPath = AppPath
//        + File.separator + "SharedPreferences"
//        val LogPath = AppPath.toString() + File.separator + "Log"
//        val CachePath = AppPath.toString() + File.separator
//        + "Cache"
//        val ImagePath = AppPath.toString() + File.separator
//        + "Image"
//
//        val PortraitPath = File.separator + "portrait"
//        + File.separator
    }

    // SharedPreferences相关常量
    object SharedPreferences {
        val SharedPreferencesName = Project.ProjectName + ".sp"
        val XxxKey = "key"

        val SF_KEY_FIRST_LOGIN = "first_login"
        val SF_KEY_LOGIN_STATUS = "login"// 已登录状态
        val SF_KEY_ONLINE = "online"
        val SF_KEY_TAB_BAR_VISIBILE = "IsTabBarVisible"
        val SF_KEY_LOGIN_USERNAME = "user_name"
        val SF_KEY_LOGIN_USERPWD = "user_pwd"
        val SF_KEY_LOGIN_WEB_USER_ID = "web_user_id"
        val SF_KEY_THEME_COLOR = "theme_color"
        val SF_KEY_LOGIN_ROLE = "login_role"
        val SF_KEY_GUIDE_ON = "guide_pic_on"
        val SF_KEY_TITLE_COLOR = "title_color"
        val SF_KEY_STATUS_BAR_COLOR = "status_bar_color"

        val SF_KEY_PUSH_TOGGLE = "push_toggle"
        val SF_KEY_PUSH_ID = "push_id"

        // 服务器ip、端口、项目名称KEY
        val SF_KEY_SERVER_INDEX = "server_index"
        val SF_KEY_SERVER_IP = "server_ip"
        val SF_KEY_SERVER_PORT = "server_port"
        val SF_KEY_SERVER_PROJECT_NAME = "server_project_name"

        // 上一次自定义的服务器ip、端口、项目名称KEY
        val SF_KEY_LAST_SERVER_IP = "last_server_ip"
        val SF_KEY_LAST_SERVER_PORT = "last_server_port"
        val SF_KEY_LAST_SERVER_PROJECT_NAME = "last_server_project_name"

        // 是否记住密码、密码可见以否KEY
        val SF_KEY_IS_SAVE_PW = "is_save_pw"
        val SF_KEY_PW_IS_SEE = "pw_is_see"

        val SF_KEY_IS_FIRST_UPDATE = "is_first_update"

        // 定位经纬度地址
        val SF_KEY_LOCATION_ADDRESS = "location_address"

        // 定位城市
        val SF_KEY_LOCATION_CITY = "location_city"

        val SF_KEY_LOCATION_LNG = "location_lng"

        val SF_KEY_LOCATION_LAT = "location_lat"

        val TODAY_NOTIFIED_UPDATE = "today_notified_update"

        //监听网络变化
        val AUTOMATIC_UPDATES_WIFI = "automatic_updates_wifi"
        val AUTOMATIC_UPDATES_NETWORK = "automatic_updates_network"
    }

    // DataBase相关常量
    object DataBase {
        val DataBaseName = Project.ProjectName + ".db"
        val DataBaseVersion = 1
        //建表语句,创建保存进度条信息的表
        val CreateFileInfoTable = "CREATE TABLE IF NOT EXISTS ma_fileinfo " + "(id INTEGER PRIMARY KEY AUTOINCREMENT, url VARCHAR, length INTEGER,start INTEGER,now INTEGER,versionCode VARCHAR)"
    }

    // HttpMethod相关常量
    object HttpMethod {
        val GET = 1
        val POST = 2
        val TIME_OUT = 15 * 1000
        val HEAD_PARAMS = "head"
        val BODY_PARAMS = "body"
        val MSG_ONSTART = 100
        val MSG_ONFINISH = 101
        val MSG_FAULT = 102
        val MSG_SUCCESS = 103

        val URL_GETADRESS = "mobile/getAddr.shtml"
        val URL_GETCARDATA = "mobile/getCodeMaster.shtml"
        val URL_LOGIN = "mobile/login.shtml"
        val URL_DRIVER_LOGIN = "mobile/driver/login.shtml"
        val URL_REGISTER = "mobile/register.shtml"
        val URL_MODIFY_PASSWORD = "mobile/updatePwd.shtml"
        val URL_CARSOURCE_FIND = "mobile/VehicleSourceManager/vehicleSourceQuery.shtml"
        val URL_GET_NEWS = "mobile/AnnouncementManager/getPlatFormList.shtml"
        val URL_GOODS_RELEASE = "mobile/resourceManage/insertSourceOfGoodsItemView.shtml"
        val URL_MY_GOODS = "mobile/resourceManage/getSourceOfGoodsItemViews.shtml"
        val URL_DELETE_GOODS = "mobile/resourceManage/deleteSourceOfGoodsItemView.shtml"
        val URL_TRANSPORT_ORDER_QUERY = "mobile/ordersBack/transportOrderQuery.shtml"
        val URL_MY_TASK_QUERY = "mobile/driver/myTask.shtml"
        val URL_GET_ORDER = "mobile/driver/getorderByPhone.shtml"

        val URL_POST_GPS_INFO = "mobile/Gps/addGpsInfo.shtml"// GPS信息上传接口
        val URL_GET_ORDER_STATE = "mobile/driver/getWayBillEvent.shtml"// 订单状态接口

        val URL_PICK_NOTIFY = "mobile/ordersBack/driver/order/pickupNotice.shtml"
        val URL_PICK_OVER = "mobile/ordersBack/driver/order/pickuped.shtml"
        val URL_DELIVER_NOTIFY = "mobile/ordersBack/driver/order/delivery.shtml"
        val URL_SIGN = "mobile/ordersBack/driver/order/sign.shtml"

        val URL_CAR_TRACK = "mobile/driver/vehicleTrack.shtml"
        val URL_TEMP_TRACK = "mobile/driver/vehicleTemperature.shtml"
        val URL_PRINT_TEMPERATURE = "mobile/driver/printTemperature.shtml"

        val URL_ORDER_SIGN = "mobile/ordersBack/carrier/order/sign.shtml"// 签收接口

        val URL_ORDER_DETAIL = "mobile/driver/transportOrderQuery.shtml"// 订单详情
        val URL_NEWS_DETAIL = "mobile/AnnouncementManager/getPlatFormById.shtml"

        val URL_DRIVER_LOGIN_VERIFY = "mobile/driver/getSmsCode.shtml"
        val URL_REGISTER_VERIFY = "mobile/register/getSmsCode.shtml"

        val URL_FIND_PWD_VERIFY = "mobile/member/getByMobile.shtml"// 找回密码发送验证码
        val URL_FIND_PWD_PHONE_VERIFY = "mobile/member/getByMobileAndCode.shtml"// 找回密码验证手机

        // 注册验证手机号存在性
        val URL_REGISTER_VERIFY_PHONE = "mobile/noAuth/validateIsUnique.shtml"

        // 查找消息。。
        val URL_SEARCH_MSG = "mobile/message/page.shtml"
        val URL_PORTRAIT = "mobile/member/updateMemberInfo.shtml"

        // 常用收发货人
        val URL_USED_CONTACTS = "mobile/ordersBack/order/contactsPage.shtml"
        // 保存常用联系人
        val URL_SAVE_USED_CONTACTS = "mobile/ordersBack/FrequentContacts/saveContact.shtml"
        // 常用货物
        val URL_USED_GOODS = "mobile/ordersBack/page.shtml"
        // 保存常用货物
        val URL_SAVE_USED_GOODS = "mobile/ordersBack/saveCommon.shtml"
        // 提交下单
        val URL_SAVE_ORDER = "mobile/ordersBack/order/save.shtml"
        // 扫码支付查询
        val URL_SCAN_PAY_SEARCH = "mobile/ordersBack/findOrderByScanCode.shtml"
        val URL_SCAN_PAY_SIGN = "mobile/ordersBack/scanOrderSign.shtml"
        val URL_TASK_NUM = "mobile/ordersBack/driver/getTaskNum.shtml"

        /**
         * 装车
         */
        val URL_LOAD_CAR = "mobile/driver/loadingVehicle.shtml"
        // 交车
        val URL_UNLOAD_CAR = "mobile/driver/returnVehicle.shtml"
        /**
         * 获取装车车辆
         */
        val URL_VEHICLE_LIST = "mobile/driver/getVehicleNoList.shtml"
        // 获取交车信息
        val URL_LOADING_VEHICLE_INFO = "mobile/driver/getLastVehicle.shtml"
        // 获取同一个调度单号下的运单号
        val URL_DISPATCH_ORDERS = "mobile/getPartDispatchOrderDetail.shtml"
        // 批量签收
        val URL_BATCH_SIGN = "mobile/driver/order/batchSign.shtml"
        /**
         * 未上传订单的回单
         */
        val URL_NO_UPLOAD_ORDERS = "mobile/driver/getNoReceiptForList.shtml"
        /**
         * 扫码查询回单的回单
         */
        val URL_GET_NO_RECEIPT_FOR_SCAN = "mobile/driver/getNoReceiptForScan.shtml"
        /**
         * 回单上传
         */
        val URL_RECEIPT_UPLOAD = "mobile/driver/receiptUpload.shtml"
        /**
         * 异常登记
         */
        val URL_EXCEPTION_REGISTER = "mobile/driver/scanExceptionForWayBill.shtml"
        val URL_EXCEPTION_SAVE = "mobile/driver/saveScanAllException.shtml"
        // 获取已签收订单
        val URL_SIGNED_ORDER = "mobile/driver/getScanForNotException.shtml"
        /**
         * 批量异常URL
         */
        val URL_SCAN_PART_EXCEPTION = "mobile/driver/scanPartException.shtml"
        // 根据运单号获取调度单底下相同收货人和收货地址
        val URL_SAME_RECEIVER = "mobile/getSmsByLegno.shtml"
        // 司机批量送货通知
        val URL_DRIVER_NOTISE = "mobile/driver/sendNoticeToOwner.shtml"
        /**
         * 司机获取提货装车信息
         */
        val URL_LIST_SCAN_FOR_TAKE = "mobile/driver/listScanForTake.shtml"
        /**
         * 司机获取提货装车信息
         */
        val URL_LIST_SCAN_FOR_SIGN = "mobile/driver/listScanForSign.shtml"
        /**
         * 司机获取提货、装车信息
         */
        val URL_BATCH_SCAN_FOR_TAKE = "mobile/driver/batchScanForTake.shtml"
        /**
         * 司机获取送货、签收信息
         */
        val URL_BATCH_SCAN_FOR_SIGN = "mobile/driver/batchScanForSign.shtml"
        /**
         * 司机获取逐单扫描信息
         */
        val URL_SINGLE_SCAN_FOR_ALL = "mobile/driver/singleScanForAll.shtml"
        /**
         * 司机获取逐单扫描信息
         */
        val URL_LIST_SCAN_FOR_TAKE_DETAIL = "mobile/driver/listScanForTakeDetail.shtml"
        val URL_LIST_SCAN_FOR_SIGN_DETAIL = "mobile/driver/listScanForSignDetail.shtml"
        /**
         * 获取版本信息
         */
        val URL_GET_APP_VERSION = "mobile/common/getAppVersion.shtml"

        /**
         * 司机获取逐单扫结果提交
         */
        val URL_OPERATE_SURE_FOR_SINGLE = "mobile/driver/operateSureForSingle.shtml"
        /**
         * 司机获取批量扫结果提交
         */
        val URL_OPERATE_SURE_FOR_BATCH = "mobile/driver/operateSureForBatch.shtml"

        /**
         * 电子围栏接口
         */
        val URL_ELECTRONIC_FENCE = "mobile/driver/getSignRange.shtml"

        /**
         * 逐单接驳装车、卸车扫描接口
         */
        val URL_SINGLE_SCAN_FOR_TRANSHIP = "mobile/driver/singleScanForTranship.shtml"

        /**
         * 批量、整车接驳装车、卸车扫描接口
         */
        val URL_BATCH_SCAN_FOR_TRANSHIP = "mobile/driver/batchScanForTranship.shtml"

        /**
         * 逐单接驳装车、卸车确认接口
         */
        val URL_OPERATE_SURE_FOR_TRANSHIP = "mobile/driver/operateSureForTranship.shtml"

        /**
         * 批量、整车接驳装车、卸车确认接口
         */
        val URL_BATCH_OPERATE_FOR_TRANSHIP = "mobile/driver/batchOperateForTranship.shtml"

        /**
         * 网点信息查询接口
         */
        val URL_GET_SERVICE_BRANCH = "mobile/driver/getServiceBranch.shtml"
    }

    // Url相关常量
    object Url {
        // 阿里云UAT
        var SERVER_IP = ""
        var SERVER_PORT = ""    // 服务器端口号
        var SERVER_PROJECT_NAME = ""    // 服务器项目名称
        var IMAGE_UPLOAD_IP = ""
        var IMAGE_LOAD_IP = ""

        //生产环境域名
        //		 public static final String SERVER_IP 			= "http://app.e-jlt.com";
        //		 public static final String SERVER_PORT 		= "";	// 服务器端口号
        //		 public static final String SERVER_PROJECT_NAME = "";	// 服务器项目名称
        //		 public static final String IMAGE_UPLOAD_IP 	= "http://file.e-jlt.com/";
        //		 public static final String IMAGE_LOAD_IP 		= "http://file.e-jlt.com/photo/";

        // 生产环境
        // public static final String SERVER_IP 			= "http://139.196.251.165";
        // public static final String SERVER_PORT 			= "";	// 服务器端口号
        // public static final String SERVER_PROJECT_NAME 	= "";	// 服务器项目名称
        // public static final String IMAGE_UPLOAD_IP 		= "http://120.55.162.213/";
        // public static final String IMAGE_LOAD_IP 		= "http://120.55.162.213/photo/";

        // 内网测试环境
        //		 public static final String SERVER_IP 			= "http://192.168.70.26";
        //		 public static final String SERVER_PORT 		= "8081";		// 服务器端口号
        //		 public static final String SERVER_PROJECT_NAME = "jlt-mobile";	// 服务器项目名称
        //		 public static final String IMAGE_UPLOAD_IP 	= SERVER_IP + ":" + SERVER_PORT + "/";
        //		 public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/photo/";

        // 内网测试环境
        //		 public static final String SERVER_IP 			= "https://192.168.0.193";
        //		 public static final String SERVER_PORT 		= "8443";		// 服务器端口号
        //		 public static final String SERVER_PROJECT_NAME = "jlt-mobile";	// 服务器项目名称
        //		 public static final String IMAGE_UPLOAD_IP 	= SERVER_IP + ":" + SERVER_PORT + "/";
        //		 public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/photo/";

        // 内网测试环境
        //		 public static final String SERVER_IP 			= "http://192.168.0.193";
        ////		 public static final String SERVER_IP 			= "http://192.168.70.24";	// Bryan
        ////		 public static final String SERVER_IP 			= "http://192.168.70.26";	// Ives
        //		 public static final String SERVER_PORT 		= "8080";		// 服务器端口号
        ////		 public static final String SERVER_PORT 		= "8081";		// 服务器端口号	// Ives
        //		 public static final String SERVER_PROJECT_NAME = "jlt-mobile";	// 服务器项目名称
        //		 public static final String IMAGE_UPLOAD_IP 	= SERVER_IP + ":" + SERVER_PORT + "/";
        //		 public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/photo/";

        // 阿里云UAT
        //		 public static final String SERVER_IP 			= "http://139.196.99.87";
        //		 public static final String SERVER_PORT 		= "8080";		// 服务器端口号
        //		 public static final String SERVER_PROJECT_NAME = "jlt-mobile";	// 服务器项目名称
        ////		 public static final String IMAGE_UPLOAD_IP 	= "http://139.196.99.87:8080/jlt-file/";
        //		 public static final String IMAGE_UPLOAD_IP 	= "http://139.196.99.87:8080/";
        //		 public static final String IMAGE_LOAD_IP 		= "http://139.196.99.87:8080/jlt-file/photo/";

        // SIT外网测试环境
        //		public static final String SERVER_IP 			= "http://59.60.9.7";
        //		public static final String SERVER_PORT 			= "8088"; 			// 服务器端口号
        //		public static final String SERVER_PROJECT_NAME 	= "jlt-mobile"; 	// 服务器项目名称
        ////		public static final String IMAGE_UPLOAD_IP 	= SERVER_IP + ":" + SERVER_PORT + "/jlt-file/";
        //		public static final String IMAGE_UPLOAD_IP 		= SERVER_IP + ":" + SERVER_PORT + "/";
        //		public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8088/jlt-file/";

        // bryan
        // public static final String SERVER_IP 			= "http://192.168.30.245";
        // public static final String SERVER_PORT 			= "8090";		// 服务器端口号
        // public static final String SERVER_PROJECT_NAME 	= "jlt-mobile";	// 服务器项目名称
        // public static final String IMAGE_UPLOAD_IP 		= "http://192.168.0.193" + ":" + "8080/";
        // public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/jlt-file/";

        // ives
        // public static final String SERVER_IP 			= "http://192.168.30.73";
        // public static final String SERVER_PORT 			= "8081";		// 服务器端口号
        // public static final String SERVER_PROJECT_NAME 	= "jlt-mobile";	// 服务器项目名称
        // public static final String IMAGE_UPLOAD_IP 		= "http://192.168.0.193" + ":" + "8080/";
        // public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/jlt-file/";

        // 87演示环境
        //		 public static final String SERVER_IP 			= "http://59.60.9.11";
        //		 public static final String SERVER_PORT 		= "8082";// 服务器端口号
        //		 public static final String SERVER_PROJECT_NAME = "jlt-mobile";	// 服务器项目名称
        //		 public static final String IMAGE_UPLOAD_IP = SERVER_IP + ":" + SERVER_PORT + "/";
        //		 public static final String IMAGE_LOAD_IP = SERVER_IP + ":" + "8080/photo/";

        // 集群
        // public static final String SERVER_IP 			= "http://139.224.5.25";
        // public static final String SERVER_PORT 			= "";	// 服务器端口号
        // public static final String SERVER_PROJECT_NAME 	= "";	// 服务器项目名称
        // public static final String IMAGE_UPLOAD_IP 		= SERVER_IP + ":" + SERVER_PORT + "/";
        // public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/photo/";

        //		 public static final String SERVER_IP 			= "http://139.196.99.87";
        //		 public static final String SERVER_PORT 		= "8080";// 服务器端口号
        //		 public static final String SERVER_PROJECT_NAME = "jlt-mobile";	// 服务器项目名称
        //		 public static final String IMAGE_UPLOAD_IP 	= SERVER_IP + ":" + SERVER_PORT + "/";
        //		 public static final String IMAGE_LOAD_IP 		= SERVER_IP + ":" + "8080/photo/";
    }

    object ServerName {
        val SITInternal = 0
        val UAT = 1
        val SITExternal = 2
        val Dev = 3
        val Demo = 4
        val Bryan = 5
        val Ives = 6
    }

    // SoapUrl相关常量
    object SoapUrl {
        val SOAP_NAMESPACE = ""
    }

    // 极光推送相关常量
    object JdPush {
        val PUSH_AUTHORITY = "com.mamsf.gy.driver.provider.pushmsg"
        val PUSHMSG_URI = Uri.parse("content://"
                + PUSH_AUTHORITY + "/ma_pushmsg")
    }

    // 订单状态
    object Status {
        val OFFER = "01"// 待报价
        val ACCEPT = "02"// 待受理
        val ACCEPTED = "03"// 已受理
        val DISPATCHED = "04"// 已调度
        val PICKING = "05"// 提货中
        val PICKED = "06"// 提货完成
        val DELIVERING = "07"// 送货中
        val SIGNED = "08"// 已签收
        val REFUSED = "09"// 已拒绝
        val CANCEL = "010"// 取消

        /**
         * APP主要功能详细说明--装车确认
         */
        val ORDER_TRUCK = "TRUCK"
        /**
         * APP主要功能详细说明--提货通知
         */
        val ORDER_PICKUP = "PICKUP"
        /**
         * APP主要功能详细说明--送货通知
         */
        val ORDER_DELIVERY = "DELIVERY"
        /**
         * APP主要功能详细说明--签收
         */
        val ORDER_SIGN = "SIGN"

    }

    object SignType {
        val Exact = "01"    // 准确签收
        val Inexact = "02"    // 非准确签收
        val ReceiverAddressError = "03"    // 收货地址解析异常
        val CurrentPositionError = "04"    // 当前位置解析异常
    }

    /**
     * 逐单扫描
     */
    val FLAG_SCAN_PAY = 3
    /**
     * 批量扫描
     */
    val FLAG_BATCH_SIGN = 4
    /**
     * 异常登记
     */
    val FLAG_EXCPTION_REGISTER = 5
    /**
     * 批量通知
     */
    val FLAG_NOTIFY = 6
    /**
     * 回单上传
     */
    val FLAG_RECEIPT_UPLOAD = 10

    /**
     * 接驳装车
     */
    val FLAG_FEEDER_LOADING = 7
    /**
     * 接驳卸车
     */
    val FLAG_SHUTTLE_CAR = 8

    /**
     * 逐单接驳装车、卸车
     */
    val TYPE_ONE_BY_ONE_SINGLE = 1

    /**
     * 批量接驳装车、卸车
     */
    val TYPE_TATCH = 2

    /**
     * 整车接驳装车、卸车
     */
    val TYPE_ALL_CAR = 3

    /**
     * 提货通知
     */
    val PICKING_STATUS = 500// 提货通知
    /**
     * 提货完成
     */
    val PICKED_STATUS = 600// 提货完成
    /**
     * 送货通知
     */
    val DELIVERING_STATUS = 700// 送货通知
    /**
     * 签收
     */
    val SIGNED_STATUS = 800// 签收
    /**
     * 接驳装车
     */
    val FEEDER_LOADING_STATUS = 900
    /**
     * 接驳卸车
     */
    val SHUTTLE_CAR_STATUS = 1000

    // 接驳类型
    object TranshipOperateType {
        var FeederLoading = "2"    // 接驳装车
        var ShuttleCar = "3"        // 接驳卸车
    }

    // 接驳类型
    object ScanTranshipOperateType {
        var FeederLoading = "2"    // 接驳装车
        var ShuttleCar = "3"        // 接驳卸车
    }

    // 批量、整车
    object ScanType {
        var Batch = "BATCH"    // 批量
        var Allcar = "ALLCAR" // 整车
    }

    // 批量、整车
    object TranshipType {
        var TemporaryFeeder = "1"    // 临时接驳
        var TransitPointFeeder = "2" // 中转点接驳
    }

    // 版本更新
    object Update {
        // 本地版本信息
        var localVersion = 0
        var localVersionName = "1.0.0"
        // 服務器版本信息
        var serverVersion: Double? = 0.0

        var isUpdate = false

        //新版本内容
        var appRemark = "新版本信息!"

        // 下載地址
        var downloadDir = "app/download/"

        // apk下载地址
        var SERVER_APP_DIR = Url.IMAGE_UPLOAD_IP + "app/driver/jlt-driver.apk"

        //apk名字
        var APK_NAME = "晶链通司机.apk"
    }

    var GO_TO_LOGIN_ACTION = "com.gy.driver.action.goLogin"
    var LOGINED_BY_ORTHERS_ACTION = "com.gy.driver.action.logout"

    object RequestCode {
        val PICKUP_FOR_TEMP_REQ = 100
        val PICKUP_FOR_TEMP_RES = 1001

    }

    object NotifyType {
        val SIGN = "Sign"
    }

    object NetType {
        val NETWORK_TYPE_NO_NET = "NoNet"
        val NETWORK_TYPE_WIFI = "Wifi"
        val NETWORK_TYPE_2G = "2G"
        val NETWORK_TYPE_3G = "3G"
        val NETWORK_TYPE_4G = "4G"
    }

    object GPSState {
        val OPEN = "0"
        val CLOSE = "1"
    }
}
