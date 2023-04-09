CREATE TABLE public.user (
	id uuid NOT NULL,
	password varchar(10) NOT NULL,
	login varchar(50) NOT NULL,
    name varchar(100) NOT NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id)
);