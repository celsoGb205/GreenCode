PGDMP  8                	    {         
   Green-Code    16.0    16.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
          public          postgres    false    216            P           2604    16484    cad_pessoa id    DEFAULT     n   ALTER TABLE ONLY public.cad_pessoa ALTER COLUMN id SET DEFAULT nextval('public.cad_pessoa_id_seq'::regclass);
 <   ALTER TABLE public.cad_pessoa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            �          0    16478 
   cad_pessoa 
   TABLE DATA           F   COPY public.cad_pessoa (id, nome, email, telefone, senha) FROM stdin;
    public          postgres    false    215   %       �           0    0    cad_pessoa_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cad_pessoa_id_seq', 7, true);
          public          postgres    false    216            R           2606    16486    cad_pessoa cad_pessoa_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.cad_pessoa
    ADD CONSTRAINT cad_pessoa_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.cad_pessoa DROP CONSTRAINT cad_pessoa_pkey;
       public            postgres    false    215            T           2606    16488    cad_pessoa email_unique 
   CONSTRAINT     S   ALTER TABLE ONLY public.cad_pessoa
    ADD CONSTRAINT email_unique UNIQUE (email);
 A   ALTER TABLE ONLY public.cad_pessoa DROP CONSTRAINT email_unique;
       public            postgres    false    215            �   y   x�e�1�0@��>LU'n�7DW6&�.Q0%"i����X�?�G0ij�b�����c�B��N��� c.>o� ��^ѯe:���#b��h���oZx��Դ���cM���?Ů+     