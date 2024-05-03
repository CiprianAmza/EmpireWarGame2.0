INSERT INTO user_levels (main_building_level, wood_mine_level, max_wood_mine_level, clay_mine_level, max_clay_mine_level, stone_mine_level, max_stone_mine_level, iron_mine_level, max_iron_mine_level, food_mine_level, max_food_mine_level, farm_level, max_farm_level, warehouse_level, max_warehouse_level, wall_level, max_wall_level) VALUES
(1, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10),
(1, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10, 1, 10);

INSERT INTO user_resources (current_wood, current_clay, current_stone, current_iron, current_food, current_farm_population, current_warehouse_space, current_wall_defense, seconds_needed, is_building, to_be_upgraded) VALUES
(500, 500, 500, 500, 50, 50, 100, 10, 0, 2, ''),
(500, 500, 500, 500, 50, 50, 100, 10, 0, 2, '');

INSERT INTO user_villagers (villagers_for_clay, villagers_for_wood, villagers_for_stone, villagers_for_iron, villagers_for_food, total_villagers, available_villagers) VALUES
(0, 0, 0, 0, 0, 3, 3),
(0, 0, 0, 0, 0, 3, 3);

INSERT INTO resources_per_hour (wood_per_hour, clay_per_hour, stone_per_hour, iron_per_hour, food_per_hour) VALUES
(5, 5, 5, 5, 5),
(5, 5, 5, 5, 5);
--
--INSERT INTO users (username, password, email, first_name, last_name, to_be_upgraded, active, roles, update_time_wood, update_time_food, update_time_iron, update_time_clay, update_time_stone, update_time_building, total_points, leaderboard_position, user_resources_id, user_levels_id, user_villagers_id, resources_per_hour_id) VALUES
--('lorena', '$2a$10$uNxEvVtyrGqX1yNmxFKc0egplmrMrJHGR0zlidsvHoufuMDvPZnOC', 'lorena@gmail.com', 'Lorena', 'Lorena', 'YES', true, 'USER,ADMIN', 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1);
