Scenario:find movie that not exist - should return zero movie
Given a search engine
When search movie that start with Pianista
Then searching should return 0 movies

Scenario:find movie from table
Given a search engine
Given the movies in table:
id |    name            |   type                |   director
0  |    Avatar          |   Sci-Fi              |   James Cameron
1  |    Shrek           |	Animacja            |   Andrew Adamson
2  |    Joker           |   Dramat              |   Todd Phillips
When search movie that start with Joker
Then searching should return 1 movies

Scenario: find movie that exist - should return one movie
Given a search engine
When search movie that start with Avatar
Then searching should  return 1 movies