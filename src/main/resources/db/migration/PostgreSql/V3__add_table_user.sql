CREATE TABLE public.user (
	id uuid NOT NULL,
	password varchar(10) NOT NULL,
	login varchar(50) NOT NULL,
    name varchar(100) NOT NULL,
    date_time_created timestamp,
    date_time_changed timestamp,
    user_created_id uuid,
    user_changed_id uuid,
	CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user_created FOREIGN KEY (user_created_id) REFERENCES public.user(id),
    CONSTRAINT fk_user_changed FOREIGN KEY (user_changed_id) REFERENCES public.user(id)
);