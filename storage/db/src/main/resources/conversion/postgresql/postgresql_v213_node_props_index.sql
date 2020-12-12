DROP INDEX IF EXISTS node_props_node_prop_value_idx;
CREATE INDEX node_props_node_prop_value_idx ON node_props(node_id, prop_key, prop_value);
DROP INDEX IF EXISTS node_props_prop_key_value_idx;
CREATE INDEX node_props_prop_key_value_idx ON node_props (prop_key, prop_value);
CREATE INDEX node_props_prop_value_key_idx ON node_props(prop_value, prop_key);