# Vacation Planner

# API Endpoints
> For any Axios call you need to pass your Authentication Token to the server to have access

    axios
        .get('https://build-week-vacationplanner.herokuapp.com/users/users', {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
        }
        })
        .then()
        .catch()

## GET Requests

### GET /users/users/users
> Returns all Users

### GET /users/user/{userid}
> Returns User by User ID
    {
        "userid": #,
        "username": "username",
        "userRoles": [],
        "quotes": [],
        "vacationParticipants": [
            {
                "vacation": {
                    "vacationid": 7,
                    "vacationlocation": "Hawaii",
                    "thingstodo": "Go for a hike",
                    "startdate": "January 7",
                    "enddate": "January 15",
                    "vacationParticipants": [
                        {
                            "user": {
                                "userid": 4,
                                "username": "admin"
                            }
                        }
                    ],
                    "vacationSuggestions": []
                }
            }
        ],
        "vacationSuggestions": [],
        "authority": []
    }

### GET /users/getcurrentuser
> Returns the current User based on the Auth Token

### GET /users/{userid}/vacations
> Returns all the Vacations that a User is a participant in

    [
    {
        "vacationid": 7,
        "vacationlocation": "Hawaii",
        "thingstodo": "Go for a hike",
        "startdate": "January 7",
        "enddate": "January 15",
        "vacationParticipants": [
            {
                "user": {
                    "userid": 4,
                    "username": "admin"
                }
            }
        ],
        "vacationSuggestions": []
    },
    {
        "vacationid": 16,
        "vacationlocation": "London",
        "thingstodo": "Big Ben",
        "startdate": "August 21",
        "enddate": "August 28",
        "vacationParticipants": [
            {
                "user": {
                    "userid": 4,
                    "username": "admin"
                }
            },
            {
                "user": {
                    "userid": 14,
                    "username": "Bob"
                }
            }
        ],
        "vacationSuggestions": [
            {
                "user": {
                    "userid": 14,
                    "username": "Bob"
                },
                "suggestions": {
                    "suggestionid": 17,
                    "suggest": "Go for a walk"
                }
            }
        ]
    }
    ]

### GET /vacation/{vacationid}
> Returns Vacation by Vacation ID

## POST Requests

### POST /createnewuser
> Creates a new user; requires a username and password

    {
	"username": "test8",
	"password": "test22"
    }

### POST /user/{userid}/vacation/{vacationid}/suggestion
> Creates a new Suggestion that is tied to a specific User and Vacation; requires a suggestion

    {
        "suggest": "Go for a walk"
    }

### POST /{userid}/vacation
> Creates a new Vacation and adds the User from User ID as a participant: requires a vacation

    {
        "vacationlocation": "Guam",
        "thingstodo": "Go for a run",
        "startdate": "January 12",
        "enddate": "January 19"
    }

## PUT Requests

### PUT /users/user/{userid}
> Updates a User by User ID; requires the updated User

### PUT /suggestion/{suggestionid}
> Updates a Suggestion by Suggestion ID; requires the updated Suggestion

### PUT /vacation/{vacationid}
> Updates a Vacation by Vacation ID; requires the updated Vacation
>> Note: You can only update location, things to do, start date, and end date from this endpoint. Updating Participants or Suggestions have their own endpoints.

### PUT /user/{userid}/vacation/{vacationid}
> Updates the list of participants for a vacation by User ID and Vacation ID
>> Note: the User ID passed in is for the User you want to add to the Vacation you are selecting by Vacation ID.

## Delete Requests

### DELETE /users/user/{userid}
> Deletes a User by User ID

### DELETE /suggestion/{suggestionid}
> Deletes a Suggestion by Suggestion ID

### DELETE /vacation/delete/{vacationid}
> Deletes a Vacation by Vacation ID