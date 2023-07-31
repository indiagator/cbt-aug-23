--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: credentials; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.credentials (
    username character varying(50) NOT NULL,
    password character varying(50)
);


ALTER TABLE public.credentials OWNER TO indiagator;

--
-- Name: offerportlinks; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.offerportlinks (
    id character varying(10) NOT NULL,
    offerid character varying(10),
    portid character varying(10)
);


ALTER TABLE public.offerportlinks OWNER TO indiagator;

--
-- Name: orderportlinks; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.orderportlinks (
    id character varying(10) NOT NULL,
    orderid character varying(10),
    portid character varying(10)
);


ALTER TABLE public.orderportlinks OWNER TO indiagator;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.orders (
    orderid character varying(10) NOT NULL,
    offerid character varying(10),
    buyername character varying(50),
    bid integer
);


ALTER TABLE public.orders OWNER TO indiagator;

--
-- Name: orderstatuses; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.orderstatuses (
    id character varying(10) NOT NULL,
    orderid character varying(10),
    status character varying(20)
);


ALTER TABLE public.orderstatuses OWNER TO indiagator;

--
-- Name: payments; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.payments (
    id character varying(10) NOT NULL,
    orderid character varying(10),
    offerid character varying(10),
    status character varying(10)
);


ALTER TABLE public.payments OWNER TO indiagator;

--
-- Name: ports; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.ports (
    portid character varying(10) NOT NULL,
    name character varying(50),
    city character varying(50),
    country character varying(50),
    capacity character varying(10)
);


ALTER TABLE public.ports OWNER TO indiagator;

--
-- Name: productoffers; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.productoffers (
    id character varying(10) NOT NULL,
    hscode character varying(8),
    qty integer,
    unitprice integer,
    offername character varying(50),
    sellername character varying(50)
);


ALTER TABLE public.productoffers OWNER TO indiagator;

--
-- Name: productofferstatuses; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.productofferstatuses (
    offerid character varying(10),
    status character varying(10),
    id character varying(10) NOT NULL
);


ALTER TABLE public.productofferstatuses OWNER TO indiagator;

--
-- Name: products; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.products (
    hscode character varying(8) NOT NULL,
    name character varying(50),
    unit character varying(5)
);


ALTER TABLE public.products OWNER TO indiagator;

--
-- Name: userdetails; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.userdetails (
    username character varying(50) NOT NULL,
    fname character varying(50),
    lname character varying(50) NOT NULL,
    email character varying(50),
    phone character varying(50),
    city character varying(50),
    country character varying(50)
);


ALTER TABLE public.userdetails OWNER TO indiagator;

--
-- Name: usernamewalletlinks; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.usernamewalletlinks (
    username character varying(50) NOT NULL,
    walletid character varying(10)
);


ALTER TABLE public.usernamewalletlinks OWNER TO indiagator;

--
-- Name: userportlinks; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.userportlinks (
    linkid character varying(10) NOT NULL,
    username character varying(50),
    portid character varying(50)
);


ALTER TABLE public.userportlinks OWNER TO indiagator;

--
-- Name: usertypelinks; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.usertypelinks (
    linkid character varying(10) NOT NULL,
    username character varying(50),
    type character varying(10)
);


ALTER TABLE public.usertypelinks OWNER TO indiagator;

--
-- Name: wallets; Type: TABLE; Schema: public; Owner: indiagator
--

CREATE TABLE public.wallets (
    walletid character varying(10) NOT NULL,
    balance integer
);


ALTER TABLE public.wallets OWNER TO indiagator;

--
-- Data for Name: credentials; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.credentials (username, password) FROM stdin;
indiagator	test@123
jyotirmaya	test@564
sejal	test@987
amisha	test@982
anjali	gupta
abhishek	test_234
dheeraj	test_876
diptesh	test_432
diwakar	test_093
rajan	test@345
gautam	test_876
sandeep	test_972
\.


--
-- Data for Name: offerportlinks; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.offerportlinks (id, offerid, portid) FROM stdin;
\.


--
-- Data for Name: orderportlinks; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.orderportlinks (id, orderid, portid) FROM stdin;
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.orders (orderid, offerid, buyername, bid) FROM stdin;
6786	8645	anjali	910000
7654	5435	diwakar	910000
6543	5457	amisha	2500000
4324	7883	abhishek	50000
4326	5435	dheeraj	500000
7689	4823	sejal	42000
24373	5457	rajan	2001000
26392	92158	rajan	18000
\.


--
-- Data for Name: orderstatuses; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.orderstatuses (id, orderid, status) FROM stdin;
6768	4324	ACCEPTED
6786	8645	ACCEPTED
5457	7689	REJECTED
6547	4326	ACCEPTED
45325	24373	OPEN
27967	26392	OPEN
76731	6543	ACCEPTED
73196	24373	REJECTED
80546	7654	ACCEPTED
\.


--
-- Data for Name: payments; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.payments (id, orderid, offerid, status) FROM stdin;
23799	7654	5435	DUE
\.


--
-- Data for Name: ports; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.ports (portid, name, city, country, capacity) FROM stdin;
54365	shanghai	shanghai	china	HUGE
54544	mumbai	mumbai	india	LARGE
\.


--
-- Data for Name: productoffers; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.productoffers (id, hscode, qty, unitprice, offername, sellername) FROM stdin;
7883	44020010	7	7000	coconut shell charcoal from Kerala	sejal
4823	17011120	20	2000	sugar from up	jyotirmaya
7857	72230091	20000	35	stainless steel wires thick	diptesh
5457	10011010	1000	2000	durum wheat seed quality	sejal
8645	10081010	750	1200	buckwheat seed quality	jyotirmaya
5435	17011110	1200	350	jaggery from maharashtra	diptesh
92158	10061010	17	1000	best seed quality rice from jharkhand	diptesh
\.


--
-- Data for Name: productofferstatuses; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.productofferstatuses (offerid, status, id) FROM stdin;
7883	OPEN	3442
4823	OPEN	3255
4823	SUSPENDED	6322
7857	OPEN	4540
5457	OPEN	9822
8645	OPEN	2909
5435	OPEN	4971
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.products (hscode, name, unit) FROM stdin;
72042110	empty cartridges scrap of stainless steel	ton
72042190	scrap of stainless steel not empty cartridges	ton
72230091	wires of stainless steel above 1.5mm thickness	meter
72230092	wires of stainless steel between 0.46 and 1.5mm	meter
17011110	sugarcane jaggery	qntl
17011120	khandsari sugar	qntl
44020010	charcoal of coconut shells	ton
10061010	rice of seed quality	qntl
10011010	durum wheat of seed quality	qntl
10081010	buckwheat of seed quality	qntl
\.


--
-- Data for Name: userdetails; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.userdetails (username, fname, lname, email, phone, city, country) FROM stdin;
indiagator	prateek	kishore	indiagator@gmail.com	534563646	\N	\N
jyotirmaya	jyotirmaya	vasaniwal	jyotirmaya@gmail.com	45435355	\N	\N
sejal	sejal	pachchigar	sejal@gmail.com	42354355	\N	\N
amisha	amisha	pagare	amisa@gmail.com	435435543	\N	\N
diptesh	diptesh	thakare	diptesh@gmail.com	9873215632	\N	\N
anjali	anjali	gupta	anjali@gmail.com	324246667	\N	\N
abhishek	abhishek	parab	abhishek@gmail.com	65467337	\N	\N
dheeraj	dheeraj	kumar	dheeraj@gmail.com	42325346	\N	\N
diwakar	diwakar	shah	diwakar@gmail.com	54377876	\N	\N
rajan	rajan	shukla	rajan@gmail.com	983283832	\N	\N
sandeep	sandeep	baludheringe	sandeep@gmail.com	983283832	beijing	china
gautam	gauatm	k	gautam@gmail.com	57678989	mumbai	india
\.


--
-- Data for Name: usernamewalletlinks; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.usernamewalletlinks (username, walletid) FROM stdin;
indiagator	5435
jyotirmaya	5436
sejal	1234
amisha	9078
anjali	7453
abhishek	9857
dheeraj	4543
diptesh	3213
diwakar	9874
\.


--
-- Data for Name: userportlinks; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.userportlinks (linkid, username, portid) FROM stdin;
67969	sandeep	54365
23568	gautam	54544
12669	diwakar	54544
37250	diptesh	54365
31530	sandeep	54544
26358	gautam	54365
\.


--
-- Data for Name: usertypelinks; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.usertypelinks (linkid, username, type) FROM stdin;
5794	indiagator	ADMIN
6944	jyotirmaya	SELLER
7279	sejal	BUYER
5144	sejal	SELLER
8835	amisha	BUYER
8053	diptesh	SELLER
5243	anjali	BUYER
3081	abhishek	BUYER
3110	dheeraj	BUYER
9115	diwakar	BUYER
39200	rajan	BUYER
36432	sandeep	LP
11221	gautam	LP
\.


--
-- Data for Name: wallets; Type: TABLE DATA; Schema: public; Owner: indiagator
--

COPY public.wallets (walletid, balance) FROM stdin;
5435	0
5436	0
1234	0
9078	0
7453	0
9857	0
4543	0
3213	0
9874	0
\.


--
-- Name: credentials credentials_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.credentials
    ADD CONSTRAINT credentials_pk PRIMARY KEY (username);


--
-- Name: productoffers key_name; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.productoffers
    ADD CONSTRAINT key_name PRIMARY KEY (id);


--
-- Name: offerportlinks offerportlinks_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.offerportlinks
    ADD CONSTRAINT offerportlinks_pk PRIMARY KEY (id);


--
-- Name: orderportlinks orderportlinks_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.orderportlinks
    ADD CONSTRAINT orderportlinks_pk PRIMARY KEY (id);


--
-- Name: orders orders_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pk PRIMARY KEY (orderid);


--
-- Name: orderstatuses orderstatuses_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.orderstatuses
    ADD CONSTRAINT orderstatuses_pk PRIMARY KEY (id);


--
-- Name: payments payments_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT payments_pk PRIMARY KEY (id);


--
-- Name: ports ports_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.ports
    ADD CONSTRAINT ports_pk PRIMARY KEY (portid);


--
-- Name: products products_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pk PRIMARY KEY (hscode);


--
-- Name: productofferstatuses statuses_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.productofferstatuses
    ADD CONSTRAINT statuses_pk PRIMARY KEY (id);


--
-- Name: userdetails userdetails_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.userdetails
    ADD CONSTRAINT userdetails_pk PRIMARY KEY (username);


--
-- Name: usernamewalletlinks usernamewalletlinks_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.usernamewalletlinks
    ADD CONSTRAINT usernamewalletlinks_pk PRIMARY KEY (username);


--
-- Name: userportlinks userportlinks_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.userportlinks
    ADD CONSTRAINT userportlinks_pk PRIMARY KEY (linkid);


--
-- Name: usertypelinks usertypelinks_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.usertypelinks
    ADD CONSTRAINT usertypelinks_pk PRIMARY KEY (linkid);


--
-- Name: wallets wallets_pk; Type: CONSTRAINT; Schema: public; Owner: indiagator
--

ALTER TABLE ONLY public.wallets
    ADD CONSTRAINT wallets_pk PRIMARY KEY (walletid);


--
-- PostgreSQL database dump complete
--

