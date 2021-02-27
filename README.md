# moviebookingproject

booking-service:
     port=8081
     end points /booking/
                        /all->get Request -> bookingdetails
                       /  ->post requst-> save new booking details
                       
                       id/{id} ->get request->fetch by booking id
                       
                       name/{name}->get request->fetch by person name
                       
                       contact/{contact}->get request->fetch by contact number
                       
                       email/{email}-> get request ->fetch by email
                       
                       cancel/{id}->delete Request-> delete booking
                       
                       edit/{id}->put request ->@request body edit details
                       
================================================================================================
movie-service:
    port=8082
      end points /movie/
                    /->post request ->@Requestbody -> movie model
                   
                   /movie-in-dates ->post request ->@RequestBody -> return list of movie between the dates
                   
                   /all ->get request-> return list of movies
                   
                   /id/{id} -> get request -> fetch s=movie by movie id
                   
                   /name/{name}->get request->fetch movie by name
                   
                   /edit/{id}-> put requst ->edit movie details by id
                   
                   
 ===============================================================================================
moviehall-service
   port:8083
        end points       /moviehall/
                         /all->get request -> find all movie
                         /movie/{movie} ->get request -> fetch moviehall by movie name
 
 
 ===================================================================================================
 
  service-registry
     port:8084
           registry  ing service 
                            MOVIE-SERVICE
                            BOOKING-SERVICE
                            MOVIEHALL-SERVICE
                            API-GATEWAY                         
  ====================================================================================================
  api-gateway
    port:8085
           mapping routes requests 
                            MOVIE-SERVICE  ---->/movie-api/**
                            BOOKING-SERVICE---->/booking-api/**
                            MOVIEHALL-SERVICE-->/moviehall-api/**
  =================================================================================                         
      
 

