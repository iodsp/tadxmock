create table dsp (
  dsp_id VARCHAR(256) PRIMARY KEY,
  name VARCHAR(256),
  desc VARCHAR(256),
  token VARCHAR(256),
  add_time TIMESTAMP,
  update_time TIMESTAMP
);

create table dsp_config (
  dsp_id VARCHAR(256),
  mapping_url VARCHAR(256),
  bid_url VARCHAR(256),
  win_notice_url VARCHAR(256),
  qps INTEGER ,
  no_cm_response VARCHAR(256),
  use_tuserinfo VARCHAR(256),
  rtb_msg_format VARCHAR(256),
  add_time TIMESTAMP,
  update_time TIMESTAMP
);
