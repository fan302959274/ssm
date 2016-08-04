USE tcz;

drop table if exists tcz_member;

/*==============================================================*/
/* Table: tcz_member                                            */
/*==============================================================*/
create table tcz_member
(
   id                   bigint(20) not null default 0 comment 'id',
   create_date          datetime not null default '1990-01-01' comment '创建时间',
   modify_date          datetime not null default '1990-01-01' comment '修改时间',
   address              varchar(255) not null default '' comment '地址',
   amount               decimal(18,4) not null default 0.0000 comment '会员金额',
   balance              decimal(18,2) not null default 0.00 comment '欠款',
   birth                datetime not null default '1990-01-01' comment '生日',
   email                varchar(255) not null default '' comment '邮箱',
   gender               int(2) not null default 0 comment '性别(0:男,1:女)',
   is_enabled           int(2) not null default 0 comment '是否激活',
   is_locked            int(2) not null default 0 comment '是否被锁',
   locked_date          datetime not null default '1990-01-01' comment '被锁日期',
   login_date           datetime not null default '1990-01-01' comment '登录日期',
   login_failure_count  int(10) not null default 0 comment '失败次数',
   login_ip             varchar(255) not null default '' comment '登录ip',
   mobile_phone         varchar(255) not null comment '手机',
   name                 varchar(255) not null default '' comment '名称',
   user_photo           varchar(255) not null default '' comment '用户图像',
   password             varchar(255) not null default '' comment '密码',
   fixed_phone          varchar(255) not null default '' comment '固定电话',
   point                bigint(20) not null default 0 comment '积分',
   register_ip          varchar(255) not null comment '注册ip',
   area_id              bigint(20) not null default 0 comment '区域id',
   member_rank_id       bigint(20) not null default 0 comment '会员等级id',
   primary key (id)
);

alter table tcz_member comment '会员表';



drop table if exists tcz_member_rank;

/*==============================================================*/
/* Table: tcz_member_rank                                       */
/*==============================================================*/
create table tcz_member_rank
(
   id                   bigint(20) not null default 0 comment 'id',
   create_date          datetime not null default '1990-01-01' comment '创建时间',
   modify_date          datetime not null default '1990-01-01' comment '修改时间',
   amount               decimal(18,4) not null default 0.0000 comment '金额',
   is_default           int(1) not null default 0 comment '是否默认',
   is_special           int(1) not null default 0 comment '是否特殊',
   name                 varchar(100) not null default '' comment '等级名称',
   scale                double not null default 0 comment '等级',
   primary key (id)
);

alter table tcz_member_rank comment '会员等级';



drop table if exists tcz_member_ralation;

/*==============================================================*/
/* Table: tcz_member_ralation                                   */
/*==============================================================*/
create table tcz_member_ralation
(
   id                   bigint(20) not null default 0 comment 'id',
   member_id            bigint(20) not null default 0 comment '会员id',
   friend_id            bigint(20) not null default 0 comment '好友id',
   team_date            datetime not null default '1990-01-01' comment '添加日期',
   primary key (id)
);

alter table tcz_member_ralation comment '会员关系表';



drop table if exists tcz_member_collection;

/*==============================================================*/
/* Table: tcz_member_collection                                 */
/*==============================================================*/
create table tcz_member_collection
(
   id                   bigint(20) not null default 0 comment 'id',
   member_id            bigint(20) not null default 0 comment '会员id',
   product_id           bigint(20) not null default 0 comment '商品id',
   collection_date      datetime not null default '1990-01-01' comment '关注时间',
   primary key (id)
);

alter table tcz_member_collection comment '会员关注表';



drop table if exists tcz_member_address;

/*==============================================================*/
/* Table: tcz_member_address                                    */
/*==============================================================*/
create table tcz_member_address
(
   id                   bigint(20) not null default 0 comment 'id',
   member_id            bigint(20) not null default 0 comment '会员id',
   address_id           bigint(20) not null default 0 comment '地址id',
   primary key (id)
);

alter table tcz_member_address comment '会员收货地址';



drop table if exists tcz_address;

/*==============================================================*/
/* Table: tcz_address                                           */
/*==============================================================*/
create table tcz_address
(
   id                   bigint(20) not null default 0,
   mobile_phone         varchar(255) not null default '' comment '手机',
   fixed_phone          varchar(255) not null default '' comment '固定电话',
   district_id          bigint(20) not null default 0 comment '区域id',
   detail_address       varchar(500) not null default '' comment '详细地址',
   primary key (id)
);

alter table tcz_address comment '地址';




