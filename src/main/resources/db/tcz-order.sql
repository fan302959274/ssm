/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/8/5 星期五 8:36:31                         */
/*==============================================================*/


drop table if exists tcz_order;

drop table if exists tcz_order_detail;

drop table if exists tcz_order_log;

drop table if exists tcz_plugin_config;


/*==============================================================*/
/* Table: tcz_order                                             */
/*==============================================================*/
create table tcz_order
(
   id                   bigint(30) not null comment '订单id',
   sn              varchar(50)  not null comment '订单编号',
   status               varchar(1) not null default '0' comment '订单状态 0：未审核,1：已确认,2：已配货,3：已发货,4：已收货，5：已完成，6：待评价，7已关闭',
   user_address_id       bigint(30) comment '收货人信息id',
   address_detail       varchar(255) comment '收货地址',
   receive_name         varchar(30) comment '收货人',
   receive_tell         varchar(30) comment '联系方式',
   zip_code             varchar(15) comment '邮编',
   ship_type            varchar(1) default '0' comment '配送方式',
   ship_no				varchar(50) default '' comment '配送单号',
   plugin_config_id     varchar(1) default '0' comment '支付类型',
   is_Invoice           varchar(1) not null default '0' comment '是否开票',
   invoice_info         varchar(255) comment '开票信息',
   comment              varchar(255) comment '备注',
   create_date          datetime not null,
   modify_date          datetime not null,
   delete_flag          varchar(1) not null default '0' comment '可用标识 0可用 ,1删除',
   pay_amount           decimal(10) comment '实付金额',
   pay_status           varchar(1) not null default '0' comment '支付状态 0:未支付，1已支付',
   evaluate_level       varchar(1) comment '评价等级 0差评，1中评，2好评',
   evaluate_content     longtext comment '评价内容',
   member_id            bigint(30) comment '会员id',
   freight              decimal(20,4) comment '运费',
   coupon_discount      decimal(20,4) comment '折扣金额',
   periods              bigint(10) not null comment '期数',
   primary key (id)
);

alter table tcz_order comment '订单表';


/*==============================================================*/
/* Table: tcz_order_detail                                      */
/*==============================================================*/
create table tcz_order_detail
(
   id                   bigint(30) not null,
   order_id             bigint(30) not null comment '订单id',
   item_id              bigint(30) not null comment '商品id',
   order_code           varchar(30) not null comment '订单编号',
   purchasel_price      decimal(20,4) not null default 0 comment '订购单价',
   create_date          datetime not null comment '创建日期',
   modify_date          datetime not null comment '修改日期',
   delete_flag          varchar(1) not null default '0' comment '删除标识',
   cloud_code           varchar(50) comment '云购码',
   win_state            varchar(1) not null default '0' comment '中奖状态，0 未中奖 1中奖',
   primary key (id)
);

alter table tcz_order_detail comment '订单明细表';

/*==============================================================*/
/* Table: tcz_order_log                                         */
/*==============================================================*/
create table tcz_order_log
(
   id                   bigint(30) not null,
   order_id             bigint(30) not null comment '订单id',
   change_log           longtext comment '变更日志',
   create_date          datetime not null comment '创建时间',
   modify_date          datetime not null comment '修改时间',
   delete_flag          varchar(1) not null comment '删除标识',
   primary key (id)
);

alter table tcz_order_log comment '订单流水日志';


/*==============================================================*/
/* Table: tcz_plugin_config                                     */
/*==============================================================*/
create table tcz_plugin_config
(
	id 					bigint not null,
	version bigint 		not null default 0 comment '版本',
	orders int			not null default 0 comment '排序',
	attributes 			longtext  comment '支付属性',
	s_enabled 			varchar(1) not null default 0  comment '0激活，1关闭',
	create_date          datetime not null comment '创建时间',
    modify_date          datetime not null comment '修改时间',
	primary key(id)
);

alter table tcz_plugin_config comment '订单支付方式';

