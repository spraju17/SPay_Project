create table SECURITY_QUESTION(
	SECURITY_QUESTION_ID Integer primary key,
    SECURITY_QUESTION varchar(100) not null unique
    );

create table ADDRESS(
	ADDRESS_ID serial primary key,
	LINE_1 varchar(20),
    LINE_2 varchar(20),
    ZIP_CODE Integer,
    CITY varchar(20),
    DISTRICT varchar(20),
    STATE varchar(20),
    COUNTRY varchar(20),
	DEFAULT_FLAG boolean   
    );
create table USER_WALLET(
	WALLET_ID Serial primary key,
	WALLET_AMOUNT Numeric not null,
    POINTS Integer not null
    );

create table REGISTEREDUSER(
	USER_ID SERIAL not null primary key,
    EMAIL_ID varchar(64) not null unique,
    NAME varchar(40) not null,
    PHONE_NUMBER varchar(12) not null unique,
    PASSWORD varchar(150),
    USER_ROLE varchar(10) not null,
    ACCOUNT_STATUS varchar(10) not null,
    SECURITY_QUESTION_ID Integer not null references SECURITY_QUESTION(SECURITY_QUESTION_ID),
    SECURITY_ANSWER varchar(50) not null,
    ADDRESS_ID Integer references ADDRESS(ADDRESS_ID),
	TIER_LEVEL varchar(10) not null,
	WALLET_ID Integer references USER_WALLET(WALLET_ID)	
    );
create index email_password_id on registereduser (EMAIL_ID) include (PASSWORD,USER_ID);

create table TRANSACTIONS(
	TRANSACTION_ID serial primary key,
	SENDER Integer,
    RECIPIENT Integer,
    BILL_ID Integer,
    AMOUNT Numeric,
    POINTS Integer,
    TRANSACTION_STATUS varchar(20),
    COMMISSION Numeric,
	USER_ID Integer references REGISTEREDUSER(USER_ID)
    );
create table CARD(
	CARD_ID serial primary key,
	CARD_NUMBER Integer,
    CVV Integer,
    EXPIRY_MONTH Integer,
	EXPIRY_YEAR Integer,
    DEFAULT_FLAG boolean,
	USER_ID Integer references REGISTEREDUSER(USER_ID)
    );
