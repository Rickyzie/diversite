PGDMP  -                     |         	   diversite    16.1    16.0 N               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398 	   diversite    DATABASE     �   CREATE DATABASE diversite WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Chinese (Traditional)_Taiwan.950';
    DROP DATABASE diversite;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    16519    address    TABLE     q   CREATE TABLE public.address (
    id integer NOT NULL,
    address character varying(100),
    userid integer
);
    DROP TABLE public.address;
       public         heap    postgres    false    4            �            1259    16518    address_id_seq    SEQUENCE     �   CREATE SEQUENCE public.address_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.address_id_seq;
       public          postgres    false    4    226                       0    0    address_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.address_id_seq OWNED BY public.address.id;
          public          postgres    false    225            �            1259    16475    attribute_values    TABLE     ~   CREATE TABLE public.attribute_values (
    id integer NOT NULL,
    attribute_id integer,
    value character varying(255)
);
 $   DROP TABLE public.attribute_values;
       public         heap    postgres    false    4            �            1259    16474    attribute_values_id_seq    SEQUENCE     �   CREATE SEQUENCE public.attribute_values_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.attribute_values_id_seq;
       public          postgres    false    224    4                       0    0    attribute_values_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.attribute_values_id_seq OWNED BY public.attribute_values.id;
          public          postgres    false    223            �            1259    16468 
   attributes    TABLE     ]   CREATE TABLE public.attributes (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.attributes;
       public         heap    postgres    false    4            �            1259    16467    attributes_id_seq    SEQUENCE     �   CREATE SEQUENCE public.attributes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.attributes_id_seq;
       public          postgres    false    4    222                       0    0    attributes_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.attributes_id_seq OWNED BY public.attributes.id;
          public          postgres    false    221            �            1259    16649    detail_attribute_values    TABLE     �   CREATE TABLE public.detail_attribute_values (
    id integer NOT NULL,
    detail_attribute_id integer,
    value character varying(255)
);
 +   DROP TABLE public.detail_attribute_values;
       public         heap    postgres    false    4            �            1259    16639    detail_attributes    TABLE     �   CREATE TABLE public.detail_attributes (
    id integer NOT NULL,
    order_detail_id integer,
    name character varying(255)
);
 %   DROP TABLE public.detail_attributes;
       public         heap    postgres    false    4            �            1259    16567    order_detail    TABLE     �   CREATE TABLE public.order_detail (
    id integer NOT NULL,
    order_id integer,
    product_name character(100),
    quantity integer
);
     DROP TABLE public.order_detail;
       public         heap    postgres    false    4            �            1259    16431    orders    TABLE     �   CREATE TABLE public.orders (
    id integer NOT NULL,
    user_id integer,
    total_amount numeric,
    "payment_status " character varying(100),
    "order_status " character varying(100)
);
    DROP TABLE public.orders;
       public         heap    postgres    false    4            �            1259    16430    orders_id_seq    SEQUENCE     �   CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.orders_id_seq;
       public          postgres    false    220    4                       0    0    orders_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;
          public          postgres    false    219            �            1259    16552    product_attribute    TABLE     n   CREATE TABLE public.product_attribute (
    product_id integer NOT NULL,
    attribute_id integer NOT NULL
);
 %   DROP TABLE public.product_attribute;
       public         heap    postgres    false    4            �            1259    16408    products    TABLE     �   CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying,
    createtime bigint,
    "isAvailable" boolean
);
    DROP TABLE public.products;
       public         heap    postgres    false    4            �            1259    16423    products_id_seq    SEQUENCE     �   CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 &   DROP SEQUENCE public.products_id_seq;
       public          postgres    false    4    217                        0    0    products_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;
          public          postgres    false    218            �            1259    16531    shipping_info    TABLE     v  CREATE TABLE public.shipping_info (
    id integer NOT NULL,
    order_id integer,
    recipient_name character varying(255),
    recipient_address character varying(255),
    recipient_phone character varying(50),
    shipping_method character varying(100),
    tracking_number character varying(100),
    estimated_delivery_date date,
    status character varying(100)
);
 !   DROP TABLE public.shipping_info;
       public         heap    postgres    false    4            �            1259    16530    shipping_info_id_seq    SEQUENCE     �   CREATE SEQUENCE public.shipping_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.shipping_info_id_seq;
       public          postgres    false    228    4            !           0    0    shipping_info_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.shipping_info_id_seq OWNED BY public.shipping_info.id;
          public          postgres    false    227            �            1259    16400    users    TABLE     ~  CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(100),
    email character varying(100) NOT NULL,
    password_hash character varying(255),
    "phone_number " character varying(15),
    address character varying(255),
    "created_at " time with time zone DEFAULT CURRENT_TIMESTAMP,
    "updated_at " time with time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.users;
       public         heap    postgres    false    4            �            1259    16399    users_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.users_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.users_userid_seq;
       public          postgres    false    216    4            "           0    0    users_userid_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.id;
          public          postgres    false    215            O           2604    16522 
   address id    DEFAULT     h   ALTER TABLE ONLY public.address ALTER COLUMN id SET DEFAULT nextval('public.address_id_seq'::regclass);
 9   ALTER TABLE public.address ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    225    226            N           2604    16478    attribute_values id    DEFAULT     z   ALTER TABLE ONLY public.attribute_values ALTER COLUMN id SET DEFAULT nextval('public.attribute_values_id_seq'::regclass);
 B   ALTER TABLE public.attribute_values ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    224    224            M           2604    16471    attributes id    DEFAULT     n   ALTER TABLE ONLY public.attributes ALTER COLUMN id SET DEFAULT nextval('public.attributes_id_seq'::regclass);
 <   ALTER TABLE public.attributes ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221    222            L           2604    16434 	   orders id    DEFAULT     f   ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);
 8   ALTER TABLE public.orders ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219    220            K           2604    16424    products id    DEFAULT     j   ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);
 :   ALTER TABLE public.products ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            P           2604    16534    shipping_info id    DEFAULT     t   ALTER TABLE ONLY public.shipping_info ALTER COLUMN id SET DEFAULT nextval('public.shipping_info_id_seq'::regclass);
 ?   ALTER TABLE public.shipping_info ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227    228            H           2604    16403    users id    DEFAULT     h   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_userid_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216                      0    16519    address 
   TABLE DATA           6   COPY public.address (id, address, userid) FROM stdin;
    public          postgres    false    226   �[                 0    16475    attribute_values 
   TABLE DATA           C   COPY public.attribute_values (id, attribute_id, value) FROM stdin;
    public          postgres    false    224   �[       
          0    16468 
   attributes 
   TABLE DATA           .   COPY public.attributes (id, name) FROM stdin;
    public          postgres    false    222   I\                 0    16649    detail_attribute_values 
   TABLE DATA           Q   COPY public.detail_attribute_values (id, detail_attribute_id, value) FROM stdin;
    public          postgres    false    232   v\                 0    16639    detail_attributes 
   TABLE DATA           F   COPY public.detail_attributes (id, order_detail_id, name) FROM stdin;
    public          postgres    false    231   �\                 0    16567    order_detail 
   TABLE DATA           L   COPY public.order_detail (id, order_id, product_name, quantity) FROM stdin;
    public          postgres    false    230   �\                 0    16431    orders 
   TABLE DATA           _   COPY public.orders (id, user_id, total_amount, "payment_status ", "order_status ") FROM stdin;
    public          postgres    false    220   �\                 0    16552    product_attribute 
   TABLE DATA           E   COPY public.product_attribute (product_id, attribute_id) FROM stdin;
    public          postgres    false    229   �\                 0    16408    products 
   TABLE DATA           G   COPY public.products (id, name, createtime, "isAvailable") FROM stdin;
    public          postgres    false    217   ]                 0    16531    shipping_info 
   TABLE DATA           �   COPY public.shipping_info (id, order_id, recipient_name, recipient_address, recipient_phone, shipping_method, tracking_number, estimated_delivery_date, status) FROM stdin;
    public          postgres    false    228   A]                 0    16400    users 
   TABLE DATA           w   COPY public.users (id, name, email, password_hash, "phone_number ", address, "created_at ", "updated_at ") FROM stdin;
    public          postgres    false    216   ^]       #           0    0    address_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.address_id_seq', 4, true);
          public          postgres    false    225            $           0    0    attribute_values_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.attribute_values_id_seq', 1, true);
          public          postgres    false    223            %           0    0    attributes_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.attributes_id_seq', 1, false);
          public          postgres    false    221            &           0    0    orders_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.orders_id_seq', 1, false);
          public          postgres    false    219            '           0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 1, false);
          public          postgres    false    218            (           0    0    shipping_info_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.shipping_info_id_seq', 1, false);
          public          postgres    false    227            )           0    0    users_userid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.users_userid_seq', 4, true);
          public          postgres    false    215            `           2606    16524    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    226            ^           2606    16480 &   attribute_values attribute_values_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.attribute_values
    ADD CONSTRAINT attribute_values_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.attribute_values DROP CONSTRAINT attribute_values_pkey;
       public            postgres    false    224            \           2606    16473    attributes attributes_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.attributes
    ADD CONSTRAINT attributes_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.attributes DROP CONSTRAINT attributes_pkey;
       public            postgres    false    222            j           2606    16653 4   detail_attribute_values detail_attribute_values_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.detail_attribute_values
    ADD CONSTRAINT detail_attribute_values_pkey PRIMARY KEY (id);
 ^   ALTER TABLE ONLY public.detail_attribute_values DROP CONSTRAINT detail_attribute_values_pkey;
       public            postgres    false    232            h           2606    16643 (   detail_attributes detail_attributes_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.detail_attributes
    ADD CONSTRAINT detail_attributes_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.detail_attributes DROP CONSTRAINT detail_attributes_pkey;
       public            postgres    false    231            f           2606    16573    order_detail order_detail_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.order_detail DROP CONSTRAINT order_detail_pkey;
       public            postgres    false    230            Z           2606    16436    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    220            d           2606    16556 (   product_attribute product_attribute_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public.product_attribute
    ADD CONSTRAINT product_attribute_pkey PRIMARY KEY (product_id, attribute_id);
 R   ALTER TABLE ONLY public.product_attribute DROP CONSTRAINT product_attribute_pkey;
       public            postgres    false    229    229            X           2606    16415    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    217            b           2606    16538     shipping_info shipping_info_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.shipping_info
    ADD CONSTRAINT shipping_info_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.shipping_info DROP CONSTRAINT shipping_info_pkey;
       public            postgres    false    228            R           2606    16407    users unique_email 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_email UNIQUE (email);
 <   ALTER TABLE ONLY public.users DROP CONSTRAINT unique_email;
       public            postgres    false    216            T           2606    16551    users unique_phone_number 
   CONSTRAINT     _   ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_phone_number UNIQUE ("phone_number ");
 C   ALTER TABLE ONLY public.users DROP CONSTRAINT unique_phone_number;
       public            postgres    false    216            V           2606    16405    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216            l           2606    16481 3   attribute_values attribute_values_attribute_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.attribute_values
    ADD CONSTRAINT attribute_values_attribute_id_fkey FOREIGN KEY (attribute_id) REFERENCES public.attributes(id);
 ]   ALTER TABLE ONLY public.attribute_values DROP CONSTRAINT attribute_values_attribute_id_fkey;
       public          postgres    false    224    4700    222            s           2606    16654 A   detail_attribute_values attribute_values_detail_attribute_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_attribute_values
    ADD CONSTRAINT attribute_values_detail_attribute_id_fkey FOREIGN KEY (detail_attribute_id) REFERENCES public.detail_attributes(id);
 k   ALTER TABLE ONLY public.detail_attribute_values DROP CONSTRAINT attribute_values_detail_attribute_id_fkey;
       public          postgres    false    231    4712    232            r           2606    16644 8   detail_attributes detail_attributes_order_detail_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_attributes
    ADD CONSTRAINT detail_attributes_order_detail_id_fkey FOREIGN KEY (order_detail_id) REFERENCES public.order_detail(id) ON DELETE CASCADE;
 b   ALTER TABLE ONLY public.detail_attributes DROP CONSTRAINT detail_attributes_order_detail_id_fkey;
       public          postgres    false    4710    230    231            q           2606    16574 '   order_detail order_detail_order_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(id) ON DELETE CASCADE;
 Q   ALTER TABLE ONLY public.order_detail DROP CONSTRAINT order_detail_order_id_fkey;
       public          postgres    false    220    4698    230            k           2606    16437    orders orders_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_user_id_fkey;
       public          postgres    false    4694    216    220            o           2606    16562 5   product_attribute product_attribute_attribute_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_attribute
    ADD CONSTRAINT product_attribute_attribute_id_fkey FOREIGN KEY (attribute_id) REFERENCES public.attributes(id) ON DELETE CASCADE;
 _   ALTER TABLE ONLY public.product_attribute DROP CONSTRAINT product_attribute_attribute_id_fkey;
       public          postgres    false    4700    222    229            p           2606    16557 3   product_attribute product_attribute_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_attribute
    ADD CONSTRAINT product_attribute_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id) ON DELETE CASCADE;
 ]   ALTER TABLE ONLY public.product_attribute DROP CONSTRAINT product_attribute_product_id_fkey;
       public          postgres    false    217    229    4696            n           2606    16539 )   shipping_info shipping_info_order_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.shipping_info
    ADD CONSTRAINT shipping_info_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(id);
 S   ALTER TABLE ONLY public.shipping_info DROP CONSTRAINT shipping_info_order_id_fkey;
       public          postgres    false    228    220    4698            m           2606    16525    address user_address_for    FK CONSTRAINT     v   ALTER TABLE ONLY public.address
    ADD CONSTRAINT user_address_for FOREIGN KEY (userid) REFERENCES public.users(id);
 B   ALTER TABLE ONLY public.address DROP CONSTRAINT user_address_for;
       public          postgres    false    226    4694    216               %   x�3�L,NKL+"NC.#�1
τ3���b���� ���         @   x�3�4�TPv.#0���������#�	�gr~~�)�Q����ed�E2�3�b���� [Q      
      x�3�L���/�2�,.��I����� C�            x������ � �            x������ � �            x������ � �            x������ � �            x�3�4�2�4����� ��         "   x�3�,H,H-���,�2�,��O-�pb���� ��            x������ � �         p   x�3�����Sp�O��2R�SR+srR���s93�3RS
����R��9c�@��������L������T�����p��(��k�1g"g"�I�$�7�O$Cg� ތJY     