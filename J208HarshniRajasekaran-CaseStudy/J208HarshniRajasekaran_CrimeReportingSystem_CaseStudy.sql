create database crimecase;
use crimecase;
create table victims(
victim_id int primary key,
first_name varchar(25),
last_name varchar(25),
dob date,
gender varchar(20),
contact_information varchar(100)
);
create table suspects(
suspect_id int primary key,
first_name varchar(25),
last_name varchar(25),
dob date,
gender varchar(20),
contact_information varchar(100)
);
create table incidents(
incident_id int primary key,
incident_type varchar(30),
incident_date date,
location varchar(30),
des_cription varchar(100),
sta_tus varchar(25),
victim_id int,
suspect_id int,
foreign key(victim_id) references victims(victim_id),
foreign key(suspect_id) references suspects(suspect_id)
);
create table evidence(
evidence_id int primary key,
des_cription varchar(100),
location_found varchar(50),
incident_id int,
foreign key(incident_id) references incidents(incident_id)
);
create table law_enforcement_agencies(
agency_id int primary key,
agency_name varchar(20),
jurisdiction varchar(50),
contact_information varchar(100)
);
create table officers(
officer_id int primary key,
first_name varchar(25),
last_name varchar(25),
badge_number varchar(10),
r_ank int ,
contact_information varchar(100),
agency_id int,
foreign key(agency_id) references law_enforcement_agencies(agency_id)
);
create table reports(
report_id int primary key,
incident_id int,
reporting_officer int,
report_date date,
report_details varchar(100),
sta_tus varchar(30),
foreign key(incident_id) references incidents(incident_id),
foreign key(reporting_officer) references officers(officer_id)
);






  