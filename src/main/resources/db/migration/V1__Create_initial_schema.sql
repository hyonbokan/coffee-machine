-- V1__Create_initial_schema.sql

-- Table: coffee_machine
CREATE TABLE coffee_machine (
    id SERIAL PRIMARY KEY
);

-- Table: recipe
CREATE TABLE recipe (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: coffee_machine_recipe
CREATE TABLE coffee_machine_recipe (
    id SERIAL PRIMARY KEY,
    coffee_machine_id INT NOT NULL,
    recipe_id INT NOT NULL,
    FOREIGN KEY (coffee_machine_id) REFERENCES coffee_machine (id) ON DELETE CASCADE,
    FOREIGN KEY (recipe_id) REFERENCES recipe (id) ON DELETE CASCADE
);

-- Table: orders
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    recipe_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (recipe_id) REFERENCES recipe (id) ON DELETE CASCADE
);

-- Table: ingredient
CREATE TABLE ingredient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL CHECK (quantity >= 0)
);

-- Table: recipe_ingredient
CREATE TABLE recipe_ingredient (
    id SERIAL PRIMARY KEY,
    recipe_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    FOREIGN KEY (recipe_id) REFERENCES recipe (id) ON DELETE CASCADE,
    FOREIGN KEY (ingredient_id) REFERENCES ingredient (id) ON DELETE CASCADE
);