create table ORDER_INFO(
    ID                   bigint unsigned auto_increment not null comment '主键',
    ORDER_CODE           varchar(64) default '' comment '订单编码',
    USER_ID              bigint not null comment '用户ID',
    ORDER_TYPE           smallint comment '订单类型(0:电子卡卷,1:实物商品)',
    WAY_TYPE             smallint comment '订单来源(0:小程序)',
    PAY_STATUS           smallint comment '支付状态(0:未支付,1:支付失败,2:支付过期,3:已支付)',
    PAY_TYPE             smallint comment '支付类型(0:支付宝,1:微信,2:其他//TODO)',
    PAY_SUM              numeric(8,2) default 0.00 comment '支付金额',
    ORDER_SUM            numeric(8,2) default 0.00 comment '订单最终金额',
    SETTLE_SUM           numeric(8,2) default 0.00 comment '订单结算金额',
    QUANTITY             int(11) default null comment '数量',
    ORDER_STATUS         smallint comment '订单状态( 0-待付款; 1-待发货; 2-已发货; 5-订单成功; 6-退款中; 7-退款完成; 8-订单关闭;)',
    LINK_NAME            varchar(64) default '' comment '联系人姓名',
    LINK_MOBILE          varchar(64) default '' comment '联系方式',
    CREATE_TIME          timestamp comment '创建时间',
    CREATE_BY            varchar(64) default '' comment '创建人',
    UPDATE_TIME          timestamp comment '修改时间',
    UPDATE_BY            varchar(64) default '' comment '修改人',
    DELETED              char(1) not null comment '删除标志',
	PRIMARY KEY (ID)
);

alter table ORDER_INFO comment '订单信息表';


create table ORDER_DETAIL(
    ID                   bigint unsigned auto_increment not null comment '主键',
    ORDER_ID             bigint not null comment '订单主_ID',
    USER_ID              bigint not null comment '用户ID',
    ORDER_CODE           varchar(64) default '' comment '订单编码',
    GOODS_NAME           varchar(64) default '' comment '商品名称',
    GOODS_CODE           varchar(64) default '' comment '商品编码',
    GOODS_TYPE           smallint comment '产品类型(0:实物,1:卡卷,)',
    PRICE                numeric(8,2) default 0.00 comment '售卖金额',
    PRICE_SHOW            numeric(8,2) default 0.00 comment '门市金额',
    PRICE_SETTLE          numeric(8,2) default 0.00 comment '结算金额',
    DELIVERY_PRICE         numeric(8,2) default 0.00 comment '运费',
    ORDER_STATUS           smallint comment '订单状态( 0-待付款; 1-待发货; 2-已发货; 5-订单成功; 6-退款中; 7-退款完成; 8-订单关闭;)',
    QUANTITY              int(11) default null comment '数量',
    SUPPLY_ID             bigint not null comment '供应商ID',
    SUPPLY_NAME           varchar(64) comment '供应商名称',
    GOODS_SHOP_ID        bigint not null comment '所属商家id',
    GOODS_SHOP_NAME      varchar(64) comment '所属商家名字',
    RECEIVER_NAME        varchar(64) comment '收货人名字',
    RECEIVER_PHONE       varchar(64) comment '收货人电话',
    RECEIVER_DETAIL_ADDRESS varchar(128) default '' comment '收货地址',
    REMARK               varchar(256) default '' comment '备注',
    CONFIRM_STATUS       char(1) not null comment '确认收货状态(F:未确认,T:已确认)',
    REFUND_ENABLED       char(1) not null comment '是否可退(F:可退,T:不可退)',
    PAY_TIME             datetime comment '支付时间',
    DELIVERY_TIME        datetime comment '发货时间',
    RECEIVE_TIME         datetime comment '确认收货时间',
    COMMENT_TIME         datetime comment '评价时间',
    CREDENTIAL_TYPE      smallint comment '证件类型( 0:其他,1:身份证,2:护照)',
    DELIVERY_TYPE        smallint comment '配送类型(0:快递,1:自提)',
    CREATE_TIME          timestamp comment '创建时间',
    CREATE_BY            varchar(64) default '' comment '创建人',
    UPDATE_TIME          timestamp comment '修改时间',
    UPDATE_BY            varchar(64) default '' comment '修改人',
    DELETED              char(1) not null comment '删除标志',
	PRIMARY KEY (ID)
);

alter table ORDER_DETAIL comment '订单明细表';


create table GOODS_INFO(
   ID                   bigint unsigned auto_increment not null comment '主键',
   GOODS_NAME           varchar(128) comment '商品名称',
   GOODS_CODE           varchar(64) default '' comment '商品编码',
   GOODS_TYPE           smallint comment '商品类型  实物商品、虚拟商品、电子卡券',
   GROUP_CODE           varchar(64) default ''  comment '分组编码',
   CATEGORY_CODE        varchar(64) default '' comment '类目编码',
   GOODS_SHOP_ID        bigint not null comment '所属商家id',
   GOODS_SHOP_NAME      varchar(128) comment '所属商家名字',
   SUPPLY_ID            bigint not null comment '供应商Id',
   SUPPLY_NAME          varchar(128) comment '供应商name',
   LINK_IMG             varchar(256) comment '主图地址',
   LINK_MOBILE_IMG      varchar(256) comment '移动端图片地址',
   SHARE_DESC           varchar(128) comment '分享描述',
   ATTRACTION           varchar(128) comment '卖点',
   PRICE_SHOW           numeric(8,2) default 0.00 comment '门市价',
   ENABLED              char(1) comment '是否上架(F未上架 T已上架 H上架时间控制)',
   REFUND               char(1) comment '是否支持退款(F不支持 T支持)',
   OPEN_TIME            datetime default null comment '上架时间',
   SUMMARY              text comment '说明',
   CREATE_TIME          timestamp comment '创建时间',
   CREATE_BY            varchar(64) default '' comment '创建人',
   UPDATE_TIME          timestamp comment '修改时间',
   UPDATE_BY            varchar(64) default '' comment '修改人',
   DELETED              char(1) not null comment '删除标志',
   PRIMARY KEY (ID)
);

alter table GOODS_INFO comment '商品表';


create table SYS_USER(
    ID                  bigint unsigned auto_increment not null comment '主键',
    USERNAME            varchar(64) default '' comment '用户名称',
    PASSWORD            varchar(255) default '' comment '用户密码',
    PHONE               varchar(20) default '' comment '手机号',
    DEPT_ID             bigint not null comment '部门ID',
    LOCK_FLAG           char(1) not null default '0 'comment '锁定标识',
    WX_OPENID           varchar(32) default '' comment '微信登录openId',
    MINI_OPENID         varchar(32) default '' comment '小程序openId',
    CREATE_TIME         timestamp comment '创建时间',
   CREATE_BY            varchar(64) default '' comment '创建人',
   UPDATE_TIME          timestamp comment '修改时间',
   UPDATE_BY            varchar(64) default '' comment '修改人',
   DELETED              char(1) not null comment '删除标志',
    PRIMARY KEY (ID)
);

alter table SYS_USER comment '用户表';

