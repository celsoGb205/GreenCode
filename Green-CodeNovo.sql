PGDMP      )            	    {         
   Green-Code    16.0    16.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16437 
   Green-Code    DATABASE     �   CREATE DATABASE "Green-Code" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Green-Code";
                postgres    false            �            1259    16478 
   cad_pessoa    TABLE     �   CREATE TABLE public.cad_pessoa (
    id integer NOT NULL,
    nome character varying(200),
    email character varying(250),
    telefone bigint,
    senha character varying(200)
);
    DROP TABLE public.cad_pessoa;
       public         heap    postgres    false            �            1259    16483    cad_pessoa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cad_pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cad_pessoa_id_seq;
       public          postgres    false    215            �           0    0    cad_pessoa_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.cad_pessoa_id_seq OWNED BY public.cad_pessoa.id;
          public          postgres    false    216            �            1259    16561    ponto_coleta    TABLE     =  CREATE TABLE public.ponto_coleta (
    ponto_id integer NOT NULL,
    cidade character varying(255),
    bairro character varying(255),
    rua character varying(255),
    numero integer,
    tipo_lixo character varying(255),
    data_inicio timestamp without time zone,
    data_final timestamp without time zone
);
     DROP TABLE public.ponto_coleta;
       public         heap    postgres    false            �            1259    16560    ponto_coleta_ponto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ponto_coleta_ponto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.ponto_coleta_ponto_id_seq;
       public          postgres    false    218            �           0    0    ponto_coleta_ponto_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.ponto_coleta_ponto_id_seq OWNED BY public.ponto_coleta.ponto_id;
          public          postgres    false    217            U           2604    16484    cad_pessoa id    DEFAULT     n   ALTER TABLE ONLY public.cad_pessoa ALTER COLUMN id SET DEFAULT nextval('public.cad_pessoa_id_seq'::regclass);
 <   ALTER TABLE public.cad_pessoa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            V           2604    16564    ponto_coleta ponto_id    DEFAULT     ~   ALTER TABLE ONLY public.ponto_coleta ALTER COLUMN ponto_id SET DEFAULT nextval('public.ponto_coleta_ponto_id_seq'::regclass);
 D   ALTER TABLE public.ponto_coleta ALTER COLUMN ponto_id DROP DEFAULT;
       public          postgres    false    218    217    218            �          0    16478 
   cad_pessoa 
   TABLE DATA           F   COPY public.cad_pessoa (id, nome, email, telefone, senha) FROM stdin;
    public          postgres    false    215   �       �          0    16561    ponto_coleta 
   TABLE DATA           q   COPY public.ponto_coleta (ponto_id, cidade, bairro, rua, numero, tipo_lixo, data_inicio, data_final) FROM stdin;
    public          postgres    false    218   \       �           0    0    cad_pessoa_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cad_pessoa_id_seq', 8, true);
          public          postgres    false    216            �           0    0    ponto_coleta_ponto_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.ponto_coleta_ponto_id_seq', 3, true);
          public          postgres    false    217            X           2606    16486    cad_pessoa cad_pessoa_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.cad_pessoa
    ADD CONSTRAINT cad_pessoa_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.cad_pessoa DROP CONSTRAINT cad_pessoa_pkey;
       public            postgres    false    215            Z           2606    16488    cad_pessoa email_unique 
   CONSTRAINT     S   ALTER TABLE ONLY public.cad_pessoa
    ADD CONSTRAINT email_unique UNIQUE (email);
 A   ALTER TABLE ONLY public.cad_pessoa DROP CONSTRAINT email_unique;
       public            postgres    false    215            �   �   x�e˽
�0����*��ғ�iϦvpqs\Bz����Ă޽E'u����Aؗv�u�$�S0�W6P�Q�Z�l�Pp2aa6�rw&�a,�PC�z�VH8/��s�bog�?R�����4r=�<?L��R����K��D��'�����q��/@7>?      �      x�U�A
�0@����@d&#U���¥�!)������ ݾ� HS{�R��0�Vn��\����A��C��gG�,q��#�����Q��\ ���dJs�'��|}ڒ�9<Z<Ϗ�z5���Ƙ/�M-�     