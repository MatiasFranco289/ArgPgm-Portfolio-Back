# Yo Programo 3ra edicion - API Portfolio

## Que es esto?

Esto es una API desarrollada utilizando Java y Spring boot como parte del programa "Yo programo" que permitira agregar, editar y eliminar informacion de un portfolio personal trabajando en conjunto con un front end desarrollado en Angular y TypeScript.

## GET: /posts

Este endpoint devolvera una array de objetos conteniendo la informacion de todos los posts existentes.<br>
El array devuelto tendra la siguiente estructura:

    [
        {
            "id_post": 1,
            "title": "Post numero 1",
            "createdAt": "2022-11-22T23:07:26.000+00:00",
            "description": "Soy un post",
            "images": [
                {
                    "id_image": 1,
                    "imgUrl": "https://imgurl.png"
                }
            ]
        },
        {
            "id_post": 2,
            "title": "Post numero 2",
            "createdAt": "2022-11-22T23:07:31.000+00:00",
            "description": "Soy un post",
            "images": []
        },
    ]

## GET: /posts/id

Este endpoint recibira por **params** una id de tipo entero y devolvera un objeto conteniendo la informacion sobre el posts relacionado a esa id en caso de existir.<br>
El objeto devulto tendra la siguiente estructura:

    {
        "id_post": 1,
        "title": "Post numero 1",
        "createdAt": "2022-11-22T23:20:33.000+00:00",
        "description": "Soy un post",
        "images": [
            {
                "id_image": 1,
                "imgUrl": "https://www.img1.png"
            },
            {
                "id_image": 2,
                "imgUrl": "https://www.img2.png"
            }
        ]
    }

## POST: /posts

Este endpoint crea o edita en post.<br>
Recibe por **body** varios parametros:

 - id_post: (Opcional) En caso de recibir el id de un post ya existente, se editara la informacion de ese post. Si este parametros no es enviado o la id no corresponde a un post existente en su lugar se creara un nuevo post.
 - title: String con el titulo del post.
 - description: String con la descripcion del post.
 - images: Array de objetos. Cada objeto debera contener una propiedad "imgUrl" con el link de la imagen. Este objeto puede ademas contener un parametro opcional "id_image" que a su vez contendra un entero. En caso de que este parametro corresponda al id de una imagen ya existente se editara la informacion de esa imagen. En caso de no recibir este parametro o que no corresponda a ninguna imagen existente, se creara una nueva imagen relacionada a este post.
 Por lo tanto, dependiendo de como se llame permitira agregar o editar imagenes existenes relacionadas al posts. Si lo que se desea es en su lugar eliminar imagenes debera llamarse al endpoint correspondiente de "/images".

Devolvera por respuesta un objeto con la siguiente estructura:

    {
        "id_post": 1,
        "title": "Nuevo post",
        "createdAt": "2022-11-22T23:20:33.841+00:00",
        "description": "Soy un post nuevo",
        "images": [
            {
                "id_image": 1,
                "imgUrl": "https://www.image1.png"
            },
            {
                "id_image": 2,
                "imgUrl": "https://www.image1.png"
            }
        ]
    }

## DELETE: /posts/id

Este endpoint recibira por **params** una id de tipo entero y eliminara el post relacionado a esa id asi como todas las imagenes relacionadas a el, en caso de existir.<br>
Devolvera un codigo de estado.

## DELETE: /images/id

Este endpoint recibira por **params** una id de tipo entero y eliminara la imagen relacionada a esa id en caso de existir.<br>
Devolvera un codigo de estado.


## GET: /users

Este endpoint verificara las credenciales de un usuario.<br>
Recibe por **body** un objeto de la siguiente forma:

    {
        "username":"user"
        "password":"password"
    }
Devulvera **TRUE** en caso de que las credenciales sean correctas o **FALSE** de lo contrario.

## GET: /users/all

Devuelve un Array conteniendo un objeto por cada usuario.<br>
La respuesta devolvera un objeto similar a este:

    [
        {
            "id": 1,
            "username": "user1",
            "password": "****"
        },
        {
            "id": 2,
            "username": "user2",
            "password": "****"
        }
    ]

## POST: /users

Este endpoint creara o editara un usuario.<br>
Recibe por **body** un objeto de la siguiente forma:

    {
        "username": "new user",
        "password": "userPassword"
    }

Puede recibir un parametro opcional **id** que contendra un entero. En caso de que este entero coincida con el id de un usuario ya existente los datos se sobreescribiran. En caso de no recibir este parametro o que no corresponda a ningun usuario existente, simplemente creara un usuario nuevo.

## DELETE: /users/id

Este endpoint eliminara un usuario.<br>
Recibe por params un id entero y devolvera un codigo de estado.

## GET: /types

Este endpoint devolvera un array de objetos con tipos de estudios(Universitario, Curso, Grado, etc..). Cada objeto tendra una propiedad que a su vez sera otro array de objetos, conteniendo todos los estudios pertenecientes a dicho tipo.

    [
        {
            "id_type": 1,
            "name": "Universitario",
            "studies": []
        },
        {
            "id_type": 2,
            "name": "Grado",
            "studies": [
                {
                    "id_study": 2,
                    "decription": "Carrera universitara",
                    "dateInit": "2022-11-23",
                    "dateFinish": "2022-11-23"
                }
            ]
        }
    ]

## POST: /types

Este endpoint creara o editara un tipo.<br>
Recibe por **body** un JSON con el siguiente formato.

    {
        "id_type": 1,
        "name": "Nombre del tipo de estudio",
        "studies": [{
            "id_study": 1,
            "title": "Titulo del estudio",
            "decription": "Descripcion del estudio",
            "dateInit": "2022-11-23T14:13:20.903+00:00",
            "dateFinish": "2022-11-23T14:13:20.903+00:00"
        }]
    }

Nota que: 

- *id_type* es opcional. En caso de enviar un id que coincida con un tipo ya existente se procedera a editar ese tipo. Si el parametro no es enviado o el id no coincide con uno existente se procedera a crear un nuevo tipo.
- *id_study * es opcional. En caso de enviar un id que coincida con un estudio ya existente se procedera a editar ese estudio. Si el parametro no es enviado o el id no coincide con uno existente se procedera a crear un nuevo estudio que se agregara a los ya existentes bajo este tipo. 

## DELETE: /types/id

Este endpoint recibe por **params** una id numerica y si esta corresponde a un tipo de estudio existente elimina no solo el tipo sino tambien **todos los estudios pertenecientes a el.**<br>
Devolvera un codigo de estado.

## PUT: /studies/id

Recibe por **body** un JSON del siguiente formato: 

    {
        "id_study": 6,
        "title": "Nuevo titutlo",
        "decription": "Nueva descripcion",
        "dateInit": "2022-11-23T14:13:20.903+00:00",
        "dateFinish": "2022-11-23T14:13:20.903+00:00",
        "type": {
            "id_type": 4
        }
    }

Permita editar los datos de un estudio ya existente.

## DELETE: /studies/id

Recibe por **params** una id numerica y elimina un estudio.<br>
Devolvera un codigo de estado.

## GET: /places

Devulvera un Array de objetos. Cada objeto tendra a su vez una propiedad *experiences* que sera a su vez otro array de objetos conteniendo todas las experiencias relacionadas con este lugar.<br>
La respuesta tendra el siguiente formato: 

    [
        {
            "id_place": 1,
            "location": "Buenos aires, Argentina",
            "experiences": [
                {
                    "id_experience": 3,
                    "title": "FullStack developer",
                    "description": "Fullstack developer en Buenos aires",
                    "dateInit": "2022-11-23",
                    "dateFinish": "2022-11-23"
                }
            ]
        }
    ]

## POST: /places

Crea o edita un lugar. Recibe por **body** varios parametros con el siguiente formato:

    {
        "id_place": 1,
        "location": "Buenos Aires, Argentina",
        "experiences": [
            {
                "id_experience"
                "title": "Programador",
                "description": "Programador en Buenos aires",
                "dateInit": "2022-11-23T14:13:20.903+00:00",
                "dateFinish": "2022-11-23T14:13:20.903+00:00"
            }
        ]
    }

Nota que: 

- *id_place* es opcional. En caso de recibirlo y que sea un id correspondiente a un lugar ya existente se procedera a editar la informacion de ese lugar. En caso de no recibirlo o que no corresponda con ningun lugar existente, se procedera a crear un nuevo lugar.
- *id_experience* es opcional. En caso de recibirlo y que sea un id correspondiente a una experiencia ya existente se procedera a editar la informacion de esa experiencia. En caso de no recibirlo o que no corresponda con ninguna experiencia existente, se procedera a crear una nueva experiencia.
- *experiences* es opcional. En caso de recibirlo creara o editara una experiencia relacionandola con el lugar. En caso de no recibirlo de todas formas se creara o editara el lugar pero este no estara relacionado con ninguna experiencia, sin embargo esta relacion puede ser establecida mas tarde.

Devolvera el objeto creado junto con el id que se le asigno.

## DELETE: /places/id

Recibe una id numerica por **params** y en caso de que esta corresponda con el id de un lugar existente eliminara no solo el lugar **sino tambien todas las experiencias relacionadas con este lugar.**

## PUT: /experiences

Recibe por **body** varios parametros y edita una experiencia existente.<br>
Recibira un JSON del siguiente formato:

    {
        "id_experience": 3,
        "title": "Nuevo titulo",
        "description": "Nueva descripcion",
        "dateInit": "2022-11-23",
        "dateFinish": "2022-11-23",
        "place": {
            "id_place": 3
        }
    }

Devolvera un objeto similar con los datos editados.<br>
*Ten cuidado, este endpoint puede funcionar sin que envies el parametro "place" pero al hacer esto, romperas su relacion y ya no pertencera a ningun lugar por lo que no aparecera mas en los metodos GET. Si esto sucediera siempre puedes volver a llamar este endpoint asignandole un place valido.*

## DELETE: /experiences/id

Recibe una id numerica por **params** y en caso de que esta corresponda con el id de una experiencia existente la eliminara.<br>
Devuelve un codigo de estado.

## GET: /skills

Devuelve un array de objetos conteniendo todos los skills existentes. <br>
La respuesta sera un array similar a este:

    [
        {
            "id_skill": 1,
            "skill_name": "HTML",
            "percentaje": 100
        },
        {
            "id_skill": 3,
            "skill_name": "CSS",
            "percentaje": 100
        },
        {
            "id_skill": 5,
            "skill_name": "Tailwind",
            "percentaje": 100
        }
    ]


## POST: /skills

Crea un nuevo skill o edita uno existente.<br>
Recibe por body un JSON del siguiente formato:

    {
        "id_skill": 5,
        "skill_name": "JavaScript",
        "percentaje": 100
    }

Nota que:
- *id_skill* es opcional. En caso de recibirlo y que corresponda al id de una habilidad existente se procedera a editar dicha habilidad. En caso de no recibirlo o que no corresponda a ningun id de habilidad existente se procedera a crear una nueva habilidad.
- *percentaje* solo puede tomar valores entre 0 y 100 inclusive.

## DELETE: /skills/id

Recibe por **params** una id numerica y si esta corresponda al de una skill existente, la eliminara. <br>
Devolvera un codigo de estado.

*Ten cuidado, si intentas eliminar una skill que esta relacionada con algun proyecto obtendras un error. Deberas primero quitar eseta habilidad de los proyectos que la usen.*

## POST: /projects

Crea un nuevo proyecto.<br>
Recibe por **body** un JSON del siguiente formato:

    {
        "id_project": 1
        "title": "Nuevo proyecto",
        "dateInit": "2022-11-23T14:13:20.903+00:00",
        "dateFinish": "2022-11-23T14:13:20.903+00:00",
        "description": "Soy un proyecto nuevo",
        "urlGit": "https://github.com",
        "urlDeploy": "https://deploy.com", 
        "urlVideo": "https://youtube.com",
        "urlImage": "https://projectImg.png",
        "skills": [
            {"id_skill": 1},
            {"id_skill": 3}
        ]
    }

Ten en cuenta que:
- *id_project* es opcional. En caso de recibirlo y que corresponda con el id de un proyecto existente se procedera a editar dicho proyecto. En caso de no recibirlo o que su valor no corresponda a ningun id de proyecto existente se procedera a crear un nuevo proyecto.
- *urlDeploy*, *urlVideo* y *urlImage* son opcionales.
- *id_skill* debe  ser el id de un skill existente o de lo contrario obtendras errores. Si quieres agregar un skill que no existe deberas primero crearlo usando el endpoint POST de /skills. 

## DELETE: /projects/id

Recibe por **params** una id numerica y en caso de que esta corresponda al id de algun proyecto existente eliminara dicho proyecto. <br>
Devuelve un codigo de estado.