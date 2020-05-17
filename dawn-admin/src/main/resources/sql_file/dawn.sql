-- ----------------------------
-- 1、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user (
  user_id 			bigint(20) 		not null auto_increment    comment '用户ID',
  dept_id 			bigint(20) 		default null			   comment '部门ID',
  login_name 		varchar(30) 	not null 				   comment '登录账号',
  user_name 		varchar(30) 	not null 				   comment '用户昵称',
  user_type 		varchar(2) 	    default '00' 		       comment '用户类型（00系统用户）',
  email  			varchar(50) 	default '' 				   comment '用户邮箱',
  phonenumber  		varchar(11) 	default '' 				   comment '手机号码',
  sex  		        char(1) 	    default '0' 			   comment '用户性别（0男 1女）',
  avatar            varchar(100) 	default '' 				   comment '头像路径',
  password 			varchar(50) 	default '' 				   comment '密码',
  salt 				varchar(20) 	default '' 				   comment '盐加密',
  status 			char(1) 		default '0' 			   comment '帐号状态（0正常 1停用）',
  del_flag			char(1) 		default '0' 			   comment '删除标志（0代表存在 2代表删除）',
  login_date        datetime                                   comment '最后登陆时间',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP    comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark 		    text			   comment '备注',
  primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into sys_user values(1,  101, 'admin', '系统管理员', '00', 'admin@163.com', '15888888888', '0', '', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '2020-03-16 11-33-00', 'admin', '2020-03-16 11-33-00', 'admin', '2020-03-16 11-33-00', '管理员');
insert into sys_user values(2,  102, 'liyx', 'liyx', '01', 'liyx@qq.com',  '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '2020-03-16 11-33-00', 'liyx', '2020-03-16 11-33-00', 'liyx', '2020-03-16 11-33-00', '普通用户');


