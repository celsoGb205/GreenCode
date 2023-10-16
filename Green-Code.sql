PGDMP         -            	    {         
   Green-Code    15.3    15.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16406 
   Green-Code    DATABASE     �   CREATE DATABASE "Green-Code" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Green-Code";
                postgres    false            �            1259    24607 
   cad_pessoa    TABLE     �   CREATE TABLE public.cad_pessoa (
    id integer NOT NULL,
    nome character varying(200),
    email character varying(250),
    telefone bigint,
    senha character varying(200)
);
    DROP TABLE public.cad_pessoa;
       public         heap    postgres    false            �            1259    24606    cad_pessoa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cad_pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cad_pessoa_id_seq;
       public          postgres    false    215                        0    0    cad_pessoa_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.cad_pessoa_id_seq OWNED BY public.cad_pessoa.id;
          public          postgres    false    214            e           2604    24610    cad_pessoa id    DEFAULT     n   ALTER TABLE ONLY public.cad_pessoa ALTER COLUMN id SET DEFAULT nextval('public.cad_pessoa_id_seq'::regclass);
 <   ALTER TABLE public.cad_pessoa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �          0    24607 
   cad_pessoa 
   TABLE DATA           F   COPY public.cad_pessoa (id, nome, email, telefone, senha) FROM stdin;
    public          postgres    false    215   1                  0    0    cad_pessoa_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cad_pessoa_id_seq', 7, true);
          public          postgres    false    214            g           2606    24614    cad_pessoa cad_pessoa_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.cad_pessoa
    ADD CONSTRAINT cad_pessoa_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.cad_pessoa DROP CONSTRAINT cad_pessoa_pkey;
       public            postgres    false    215            i           2606    24622    cad_pessoa email_unique 
   CONSTRAINT     S   ALTER TABLE ONLY public.cad_pessoa
    ADD CONSTRAINT email_unique UNIQUE (email);
 A   ALTER TABLE ONLY public.cad_pessoa DROP CONSTRAINT email_unique;
       public            postgres    false    215            �   y   x�e�1�0@��>LU'n�7DW6&�.Q0%"i����X�?�G0ij�b�����c�B��N��� c.>o� ��^ѯe:���#b��h���oZx��Դ���cM���?Ů+     