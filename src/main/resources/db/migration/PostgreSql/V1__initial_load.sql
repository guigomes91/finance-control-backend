CREATE TABLE public.account_plan (
	id uuid NOT NULL,
	name varchar(200) NOT NULL,
    type_account varchar(20) NOT NULL,
	CONSTRAINT account_plan_pkey PRIMARY KEY (id)
);

CREATE TABLE public.account (
	id uuid NOT NULL,
    due timestamp NOT NULL,
    payment  timestamp,
	description varchar(200) NOT NULL,
	portion int4 NOT NULL,
    amount numeric(12, 2) NOT NULL,
    type_id uuid NOT NULL,
    status int4 NOT NULL,
	CONSTRAINT account_pkey PRIMARY KEY (id),
    CONSTRAINT fk_account_type FOREIGN KEY (type_id) REFERENCES public.account_plan(id)
);