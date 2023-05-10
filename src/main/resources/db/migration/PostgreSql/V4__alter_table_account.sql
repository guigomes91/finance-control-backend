ALTER TABLE account ADD COLUMN date_time_changed timestamp;
ALTER TABLE account ADD COLUMN date_time_created timestamp;
ALTER TABLE account ADD COLUMN user_created_id uuid;
ALTER TABLE account ADD COLUMN user_changed_id uuid;

ALTER TABLE account ADD CONSTRAINT fk_user_created FOREIGN KEY (user_created_id) REFERENCES public.user(id);
ALTER TABLE account ADD CONSTRAINT fk_user_changed FOREIGN KEY (user_changed_id) REFERENCES public.user(id);
