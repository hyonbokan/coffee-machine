-- Insert Ingredients
INSERT INTO ingredient (name, quantity) VALUES ('Coffee Beans', 1000);
INSERT INTO ingredient (name, quantity) VALUES ('Water', 2000);
INSERT INTO ingredient (name, quantity) VALUES ('Milk', 1000);

-- Insert Recipes
INSERT INTO recipe (name) VALUES ('Espresso');
INSERT INTO recipe (name) VALUES ('Americano');
INSERT INTO recipe (name) VALUES ('Cappuccino');

-- Espresso Recipe
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity)
VALUES 
    (1, 1, 10),  -- Espresso: Coffee Beans
    (1, 2, 30);  -- Espresso: Water

-- Americano Recipe
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity)
VALUES 
    (2, 1, 10),  -- Americano: Coffee Beans
    (2, 2, 100); -- Americano: Water

-- Cappuccino Recipe
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity)
VALUES 
    (3, 1, 10),  -- Cappuccino: Coffee Beans
    (3, 2, 30),  -- Cappuccino: Water
    (3, 3, 40);  -- Cappuccino: Milk