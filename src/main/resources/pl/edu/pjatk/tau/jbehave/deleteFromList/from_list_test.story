Scenario: And,But structure, try to delete movie that exist
Given movies in table:
id  |   name            |   type                |   director
0   |   Avatar          |   Sci-Fi              |   James Cameron
1   |   Shrek           |	Animacja            |   Andrew Adamson
2   |   Joker           |   Dramat              |   Todd Phillips
3   |   Django          |   Western             |   Quentin Tarantino
4   |   Incepcja        |   Sci-Fi              |   Christopher Nolan
When I delete movies from table:
id  |   name            |   type                |   director
1   |   Shrek           |	Animacja            |   Andrew Adamson
2   |   Joker           |   Dramat              |   Todd Phillips
3   |   Django          |   Western             |   Quentin Tarantino
4   |   Incepcja        |   Sci-Fi              |   Christopher Nolan
Then I should have in database:
id  |   name            |   type                |   director
0   |   Avatar          |   Sci-Fi              |   James Cameron
Then I should't contain:
id  |   name            |   type                |   director
3   |   Django          |   Western             |   Quentin Tarantino



Scenario:try to delete movie that do not exist
 Given movies in table:
 id  |   name            |   type                |   director
 0   |   Avatar          |   Sci-Fi              |   James Cameron
 1   |   Shrek           |	Animacja            |   Andrew Adamson
 2   |   Joker           |   Dramat              |   Todd Phillips
 3   |   Django          |   Western             |   Quentin Tarantino
 4   |   Incepcja        |   Sci-Fi              |   Christopher Nolan
 When I delete movies from table:
 id  |   name            |   type                |   director
 0   |   Avatar          |   Sci-Fi              |   James Cameron
 1   |   Shrek           |	Animacja            |   Andrew Adamson
 2   |   Joker           |   Dramat              |   Todd Phillips
 Then I should have in database:
 id  |   name            |   type                |   director
 3   |   Django          |   Western             |   Quentin Tarantino
 4   |   Incepcja        |   Sci-Fi              |   Christopher Nolan
 Then I should't contain:
 id  |   name            |   type                |   director
 2   |   Joker           |   Dramat              |   Todd Phillips
