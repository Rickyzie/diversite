PGDMP      -                 |         	   diversite    16.1    16.0 E               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            	           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398 	   diversite    DATABASE     �   CREATE DATABASE diversite WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Chinese (Traditional)_Taiwan.950';
    DROP DATABASE diversite;
                postgres    false            �            1259    16519    address    TABLE     q   CREATE TABLE public.address (
    id integer NOT NULL,
    address character varying(100),
    userid integer
);
    DROP TABLE public.address;
       public         heap    postgres    false            �            1259    16518    address_id_seq    SEQUENCE     �   CREATE SEQUENCE public.address_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.address_id_seq;
       public          postgres    false    227                       0    0    address_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.address_id_seq OWNED BY public.address.id;
          public          postgres    false    226            �            1259    16475    attribute_values    TABLE     ~   CREATE TABLE public.attribute_values (
    id integer NOT NULL,
    attribute_id integer,
    value character varying(255)
);
 $   DROP TABLE public.attribute_values;
       public         heap    postgres    false            �            1259    16474    attribute_values_id_seq    SEQUENCE     �   CREATE SEQUENCE public.attribute_values_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.attribute_values_id_seq;
       public          postgres    false    225                       0    0    attribute_values_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.attribute_values_id_seq OWNED BY public.attribute_values.id;
          public          postgres    false    224            �            1259    16468 
   attributes    TABLE     ]   CREATE TABLE public.attributes (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.attributes;
       public         heap    postgres    false            �            1259    16467    attributes_id_seq    SEQUENCE     �   CREATE SEQUENCE public.attributes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.attributes_id_seq;
       public          postgres    false    223                       0    0    attributes_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.attributes_id_seq OWNED BY public.attributes.id;
          public          postgres    false    222            �            1259    16452    order_product    TABLE     f   CREATE TABLE public.order_product (
    order_id integer NOT NULL,
    product_id integer NOT NULL
);
 !   DROP TABLE public.order_product;
       public         heap    postgres    false            �            1259    16431    orders    TABLE     �   CREATE TABLE public.orders (
    id integer NOT NULL,
    user_id integer,
    total_amount numeric,
    "payment_status " character varying(100),
    "order_status " character varying(100)
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16430    orders_id_seq    SEQUENCE     �   CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.orders_id_seq;
       public          postgres    false    220                       0    0    orders_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;
          public          postgres    false    219            �            1259    16552    product_attribute    TABLE     n   CREATE TABLE public.product_attribute (
    product_id integer NOT NULL,
    attribute_id integer NOT NULL
);
 %   DROP TABLE public.product_attribute;
       public         heap    postgres    false            �            1259    16408    products    TABLE     m   CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying,
    createtime bigint
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    16423    products_id_seq    SEQUENCE     �   CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 &   DROP SEQUENCE public.products_id_seq;
       public          postgres    false    217                       0    0    products_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;
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
       public         heap    postgres    false            �            1259    16530    shipping_info_id_seq    SEQUENCE     �   CREATE SEQUENCE public.shipping_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.shipping_info_id_seq;
       public          postgres    false    229                       0    0    shipping_info_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.shipping_info_id_seq OWNED BY public.shipping_info.id;
          public          postgres    false    228            �            1259    16400    users    TABLE     ~  CREATE TABLE public.users (
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
       public         heap    postgres    false            �            1259    16399    users_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.users_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.users_userid_seq;
       public          postgres    false    216                       0    0    users_userid_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.id;
          public          postgres    false    215            G           2604    16522 
   address id    DEFAULT     h   ALTER TABLE ONLY public.address ALTER COLUMN id SET DEFAULT nextval('public.address_id_seq'::regclass);
 9   ALTER TABLE public.address ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    227    227            F           2604    16478    attribute_values id    DEFAULT     z   ALTER TABLE ONLY public.attribute_values ALTER COLUMN id SET DEFAULT nextval('public.attribute_values_id_seq'::regclass);
 B   ALTER TABLE public.attribute_values ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            E           2604    16471    attributes id    DEFAULT     n   ALTER TABLE ONLY public.attributes ALTER COLUMN id SET DEFAULT nextval('public.attributes_id_seq'::regclass);
 <   ALTER TABLE public.attributes ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223            D           2604    16434 	   orders id    DEFAULT     f   ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);
 8   ALTER TABLE public.orders ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219    220            C           2604    16424    products id    DEFAULT     j   ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);
 :   ALTER TABLE public.products ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            H           2604    16534    shipping_info id    DEFAULT     t   ALTER TABLE ONLY public.shipping_info ALTER COLUMN id SET DEFAULT nextval('public.shipping_info_id_seq'::regclass);
 ?   ALTER TABLE public.shipping_info ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    228    229            @           2604    16403    users id    DEFAULT     h   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_userid_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216                      0    16519    address 
   TABLE DATA           6   COPY public.address (id, address, userid) FROM stdin;
    public          postgres    false    227   )P                  0    16475    attribute_values 
   TABLE DATA           C   COPY public.attribute_values (id, attribute_id, value) FROM stdin;
    public          postgres    false    225   ^P       �          0    16468 
   attributes 
   TABLE DATA           .   COPY public.attributes (id, name) FROM stdin;
    public          postgres    false    223   �P       �          0    16452    order_product 
   TABLE DATA           =   COPY public.order_product (order_id, product_id) FROM stdin;
    public          postgres    false    221   �P       �          0    16431    orders 
   TABLE DATA           _   COPY public.orders (id, user_id, total_amount, "payment_status ", "order_status ") FROM stdin;
    public          postgres    false    220   �P                 0    16552    product_attribute 
   TABLE DATA           E   COPY public.product_attribute (product_id, attribute_id) FROM stdin;
    public          postgres    false    230   Q       �          0    16408    products 
   TABLE DATA           8   COPY public.products (id, name, createtime) FROM stdin;
    public          postgres    false    217   :Q                 0    16531    shipping_info 
   TABLE DATA           �   COPY public.shipping_info (id, order_id, recipient_name, recipient_address, recipient_phone, shipping_method, tracking_number, estimated_delivery_date, status) FROM stdin;
    public          postgres    false    229   bQ       �          0    16400    users 
   TABLE DATA           w   COPY public.users (id, name, email, password_hash, "phone_number ", address, "created_at ", "updated_at ") FROM stdin;
    public          postgres    false    216   Q                  0    0    address_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.address_id_seq', 4, true);
          public          postgres    false    226                       0    0    attribute_values_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.attribute_values_id_seq', 1, false);
          public          postgres    false    224                       0    0    attributes_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.attributes_id_seq', 1, false);
          public          postgres    false    222                       0    0    orders_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.orders_id_seq', 1, false);
          public          postgres    false    219                       0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 1, false);
          public          postgres    false    218                       0    0    shipping_info_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.shipping_info_id_seq', 1, false);
          public          postgres    false    228                       0    0    users_userid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.users_userid_seq', 4, true);
          public          postgres    false    215            Z           2606    16524    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    227            X           2606    16480 &   attribute_values attribute_values_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.attribute_values
    ADD CONSTRAINT attribute_values_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.attribute_values DROP CONSTRAINT attribute_values_pkey;
       public            postgres    false    225            V           2606    16473    attributes attributes_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.attributes
    ADD CONSTRAINT attributes_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.attributes DROP CONSTRAINT attributes_pkey;
       public            postgres    false    223            T           2606    16456     order_product order_product_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_pkey PRIMARY KEY (order_id, product_id);
 J   ALTER TABLE ONLY public.order_product DROP CONSTRAINT order_product_pkey;
       public            postgres    false    221    221            R           2606    16436    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    220            ^           2606    16556 (   product_attribute product_attribute_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public.product_attribute
    ADD CONSTRAINT product_attribute_pkey PRIMARY KEY (product_id, attribute_id);
 R   ALTER TABLE ONLY public.product_attribute DROP CONSTRAINT product_attribute_pkey;
       public            postgres    false    230    230            P           2606    16415    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    217            \           2606    16538     shipping_info shipping_info_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.shipping_info
    ADD CONSTRAINT shipping_info_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.shipping_info DROP CONSTRAINT shipping_info_pkey;
       public            postgres    false    229            J           2606    16407    users unique_email 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_email UNIQUE (email);
 <   ALTER TABLE ONLY public.users DROP CONSTRAINT unique_email;
       public            postgres    false    216            L           2606    16551    users unique_phone_number 
   CONSTRAINT     _   ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_phone_number UNIQUE ("phone_number ");
 C   ALTER TABLE ONLY public.users DROP CONSTRAINT unique_phone_number;
       public            postgres    false    216            N           2606    16405    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216            b           2606    16481 3   attribute_values attribute_values_attribute_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.attribute_values
    ADD CONSTRAINT attribute_values_attribute_id_fkey FOREIGN KEY (attribute_id) REFERENCES public.attributes(id);
 ]   ALTER TABLE ONLY public.attribute_values DROP CONSTRAINT attribute_values_attribute_id_fkey;
       public          postgres    false    4694    223    225            `           2606    16457 )   order_product order_product_order_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(id);
 S   ALTER TABLE ONLY public.order_product DROP CONSTRAINT order_product_order_id_fkey;
       public          postgres    false    221    4690    220            a           2606    16462 +   order_product order_product_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);
 U   ALTER TABLE ONLY public.order_product DROP CONSTRAINT order_product_product_id_fkey;
       public          postgres    false    4688    217    221            _           2606    16437    orders orders_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_user_id_fkey;
       public          postgres    false    220    4686    216            e           2606    16562 5   product_attribute product_attribute_attribute_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_attribute
    ADD CONSTRAINT product_attribute_attribute_id_fkey FOREIGN KEY (attribute_id) REFERENCES public.attributes(id) ON DELETE CASCADE;
 _   ALTER TABLE ONLY public.product_attribute DROP CONSTRAINT product_attribute_attribute_id_fkey;
       public          postgres    false    230    223    4694            f           2606    16557 3   product_attribute product_attribute_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_attribute
    ADD CONSTRAINT product_attribute_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id) ON DELETE CASCADE;
 ]   ALTER TABLE ONLY public.product_attribute DROP CONSTRAINT product_attribute_product_id_fkey;
       public          postgres    false    230    4688    217            d           2606    16539 )   shipping_info shipping_info_order_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.shipping_info
    ADD CONSTRAINT shipping_info_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(id);
 S   ALTER TABLE ONLY public.shipping_info DROP CONSTRAINT shipping_info_order_id_fkey;
       public          postgres    false    229    220    4690            c           2606    16525    address user_address_for    FK CONSTRAINT     v   ALTER TABLE ONLY public.address
    ADD CONSTRAINT user_address_for FOREIGN KEY (userid) REFERENCES public.users(id);
 B   ALTER TABLE ONLY public.address DROP CONSTRAINT user_address_for;
       public          postgres    false    216    4686    227               %   x�3�L,NKL+"NC.#�1
τ3���b���� ���          @   x�3�4�TPv.#0���������#�	�gr~~�)�Q����ed�E2�3�b���� [Q      �      x�3�L���/�2�,.��I����� C�      �      x������ � �      �      x������ � �            x�3�4�2�4����� ��      �      x�3�,H,H-������� %�            x������ � �      �   p   x�3�����Sp�O��2R�SR+srR���s93�3RS
����R��9c�@��������L������T�����p��(��k�1g"g"�I�$�7�O$Cg� ތJY     