#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER cacti PASSWORD 'cacti';
    CREATE DATABASE cacti_data_customer OWNER cacti;
    GRANT ALL PRIVILEGES ON DATABASE cacti_data_customer TO cacti;

    CREATE DATABASE cacti_data_orders OWNER cacti;
    GRANT ALL PRIVILEGES ON DATABASE cacti_data_orders TO cacti;
EOSQL