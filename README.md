# projet_AMS_Billing

Pour lancer le projet, il faut demarer docker et instancier l'image fournit ( docker-compose.yml) avec la commande "docker-compose up -d"
Une foit l'image lancé, il faut se rendre sur kafkadrop ( http://localhost:9000/ ) et créer deux topic:
- "contract"
- "subscription"

Une fois cela fait, demarer les deux api micro service.
billing ecoute sur le port 8080 et contract sur le port 8081.
il est possible qu'il ne soit pas possible de lancer les deux api avec intelji car étant dans le même dossier.
si cela arrive il faut simplement deplacer l'un des dossier d'api dans un autre dossier pour regle le problème.

pour produire des message kakfa ( qui sont ecouter par l'api opposer à laquelle il ont été envoyer )
il existe trois end points a appeler

-deux dans contract api

-Patch: -> localhost:8081/refcontract/v1/contracts/{idref}
{
	"action": "bidule",
	"contractRef": "erfed"
}

-Post: -> localhost:8081/refcontract/v1/contracts
{
  "productRef": "DEFERRED_BILLING",
  "contractType": "DEFERRED_BILLING",
  "createdAt": "2022-04-22",
  "signedAt": "2022-04-22",
  "activatedAt": "2022-04-24",
  "expireAt": "2023-04-01",
  "status": "ACTIVE",
  "distributor": {
    "distributorRef": "esgi SA"
  },
  "subscriber": {
    "subscriberRef": "MA PETITE ENTREPRISE",
    "subscriberType": "PROFESSIONNAL",
		"contactAddress" : {
			"line1": "",
			"line2": "",
			"line3": "",
			"line4": "",
			"line5": "",
			"locality": "",
			"countryCode": "",
			"countryName": ""
		},
		"billingAddress": {
			"line1": "",
			"line2": "",
			"line3": "",
			"line4": "",
			"line5": "",
			"locality": "",
			"countryCode": "",
			"countryName": ""
		},
    "party": {
			"type": "BusinessParticularParty",
      "customerId": "PRO-8996786873",
      "customerRef": "CUSTOMER NUMBER"
    },
    "contactPerson": {
      "gender": "M",
      "firstName": "John",
      "lastName": "DOE",
      "mail": "john.doe@acme.com",
      "phone": "+33 (0)7 76 77 00 00"
    }
  },
  "custom": {
		"type":"DeferredBilling",
    "deferredBilling": {
      "creditLimit": 3000,
      "payment": {
        "paymentMethodType": "WIRETRANSFER",
        "wireTansfert": {
          "rum": "RUM08918098739762ABCGDF65524255658"
        }
      }
    }
  }
}

-un dans billing api

-Post: -> localhost:8080/billing/v1/subscriptions
{
	"subscriptionType": "DEFERRED_BILLING",
	"payment": {
		"paymentMethodType":"WIRETRANSFER",
		"wireTansfert": {
			"rum": "df",
			"bankCoordinates": null
		}
	},
	"contract": {
		"contractId": "100",
		"contractRef": "CTR-JHKJQGFSHFHGS",
		"createdAt": "2022-04-22",
		"activatedAt": "2022-04-24",
		"expireAt": "2023-04-01",
		"status": "ACTIVE"
	},
	"seller": {
		"sellerRef": "esgi SA",
		"contactPerson": {
			"gender": "M",
			"firstName": "Jean",
			"lastName": "VEND",
			"mail": "jean.vend@esgi.fr",
			"phone": "+33 (0)1 56 87 65 78"
		}
	},
	"buyer": {
		"buyerRef": "esgi SA",
		"buyerType": "PROFESSIONNAL",
		"party": {
			"type": "BusinessParticularParty",
			"customerId": "PRO-8996786873",
			"customerRef": "CUSTOMER REF"
		},
		"contactPerson": {
			"gender": "M",
			"firstName": "John",
			"lastName": "DOE",
			"mail": "john.doe@acme.com",
			"phone": "+33 (0)7 76 77 00 00"
		},
		"billingAddress": {
			"line1": "",
			"line2": "",
			"line3": "",
			"line4": "",
			"line5": "",
			"locality": "",
			"countryCode": "",
			"countryName": ""
		},
		"contactAddress": {
			"line1": "",
			"line2": "",
			"line3": "",
			"line4": "",
			"line5": "",
			"locality": "",
			"countryCode": "",
			"countryName": ""
		}
	}
}

une fois l'end point taper on peut voir que sur l'api opposer le message est consommer et afficher sous format stringifier dans la console
