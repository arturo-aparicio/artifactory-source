ALTER TABLE nodes
  ADD COLUMN sha256 CHAR(64),
  ADD COLUMN repo_path_checksum CHAR(40);