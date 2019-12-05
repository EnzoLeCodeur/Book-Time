package com.example.booktime.model;

public class Book {

    private String title;
    private int id;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    /*
"kind": "books#volume",
 "id": "k7AWCwAAQBAJ",
 "etag": "sMJDjlHZvrI",
 "selfLink": "https://www.googleapis.com/books/v1/volumes/k7AWCwAAQBAJ",
 "volumeInfo": {
  "title": "Read/Write Book 2",
  "subtitle": "Une introduction aux humanités numériques",
  "authors": [
   "Pierre Mounier"
  ],
  "publisher": "OpenEdition Press",
  "publishedDate": "2012-09-21",
  "description": "\u003cp\u003eQu’est-ce que les humanités numériques ? Apparue en 2006, l’expression connaît depuis un véritable succès. Mais au-delà du slogan à la mode, quelle est la réalité des pratiques qu’il désigne ? Si tout le monde s’accorde sur une définition minimale à l’intersection des technologies numériques et des sciences humaines et sociales, les vues divergent lorsqu’on entre dans le vif du sujet. Les humanités numériques représentent-elles une véritable révolution des pratiques de recherche et des paradigmes intellectuels qui les fondent ou, plus simplement, une optimisation des méthodes existantes ? Constituent-elles un champ suffisamment structuré pour justifier une réforme des modes de financement de la recherche, des cursus de formation, des critères d’évaluation ? L’archive numérique offre-t-elle à la recherche suffisamment de garanties ? Quelle place la recherche « dirigée par les données » laisse-t-elle à l’interprétation ? Telles sont quelques-unes des questions abordées par ce deuxième opus de la collection « Read/Write Book ». Ces dix-huit textes essentiels, rédigés ou traduits en français par des chercheurs de différentes nationalités, proposent une introduction aux humanités numériques accessible à tous ceux qui souhaitent en savoir plus sur ce domaine de recherche en constante évolution.\u003c/p\u003e",
  "industryIdentifiers": [
   {
    "type": "ISBN_10",
    "identifier": "2821813260"
   },
   {
    "type": "ISBN_13",
    "identifier": "9782821813267"
   }
  ],
  "readingModes": {
   "text": true,
   "image": true
  },
  "pageCount": 264,
  "printedPageCount": 268,
  "printType": "BOOK",
  "categories": [
   "Language Arts & Disciplines / Library & Information Science / General"
  ],
  "maturityRating": "NOT_MATURE",
  "allowAnonLogging": false,
  "contentVersion": "2.4.4.0.preview.3",
  "panelizationSummary": {
   "containsEpubBubbles": false,
   "containsImageBubbles": false
  },
  "imageLinks": {
   "smallThumbnail": "http://books.google.com/books/content?id=k7AWCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE73rz-KWu14AYDUOU2OC_wG7FDT7t3V9_7a6TxQbeN7iAFDHjdwJ0gABL9iRs5PeCBOzgPmZZmk7nJvI9U6LR26EoxF_xchPabRmg0qrZPr_xVNAqlsf7q30I1eXqpq8RLE568YS&source=gbs_api",
   "thumbnail": "http://books.google.com/books/content?id=k7AWCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE70BfUFD4PhnYdiZClUY2gHyt14AO8rQsGojL3bYANv7AYe5BTYdoA4NIVKiRPpQSgWntNiANq1a0kzmC3ffMlmyvmjLzkpd8DpcSgxDIMxx1tVBQz4A9Z7CXUsh7-oQCWYrlxfX&source=gbs_api",
   "small": "http://books.google.com/books/content?id=k7AWCwAAQBAJ&printsec=frontcover&img=1&zoom=2&edge=curl&imgtk=AFLRE71z5USOXDM19LyGa8PK4xuyr0j4S1KdoUVkSYdhxOIHlAvNs7brF9YTYFPXSOzQloelArEwLd22-uNdw5mycQAVv2a5fvZf7Mg53BgSFt_FWSh1AY2ss9Wh4yV6HqKE3PuaBr3c&source=gbs_api",
   "medium": "http://books.google.com/books/content?id=k7AWCwAAQBAJ&printsec=frontcover&img=1&zoom=3&edge=curl&imgtk=AFLRE71j0ybKTfFunH8qfOyiRvs6RMPGYT672FXeOrerQ4Nj_45MqGceGjcpJlWAaG6EHz-nmGBHaSdJZZ9sdOvOoFQnpuaT8qYh_3ZYYigcRJFIAr_8hN4_WBCRVobPleIvAwcLIY1i&source=gbs_api",
   "large": "http://books.google.com/books/content?id=k7AWCwAAQBAJ&printsec=frontcover&img=1&zoom=4&edge=curl&imgtk=AFLRE713lZyRk9MABGxjFwH39C8P1AiZiCxvAuxIyBjDlZEAdTzvnCBYu4fvszq75ZP0R5duSrHaMxCIRhH1DXWazOnWC828kN2fF3nssv5_dbPOdy8mkziWTbQ_fJRSPXdBhGCIC3hn&source=gbs_api",
   "extraLarge": "http://books.google.com/books/content?id=k7AWCwAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE721rIe7ogVe4dYcMmahi5lyM_H-FUM7fhqza6aLuLwnMkkW8T-oY_QxoYX4Lu18s8FaNQcz_M6xPGlAS7VtH6Xh9k4EaawNcBgpZ7kvYFraJJxSvR29eHU1pDChbqFvt1ivlM0o&source=gbs_api"
  },
  "language": "fr",
  "previewLink": "http://books.google.fr/books?id=k7AWCwAAQBAJ&hl=&source=gbs_api",
  "infoLink": "https://play.google.com/store/books/details?id=k7AWCwAAQBAJ&source=gbs_api",
  "canonicalVolumeLink": "https://play.google.com/store/books/details?id=k7AWCwAAQBAJ"
 },
 "layerInfo": {
  "layers": [
   {
    "layerId": "geo",
    "volumeAnnotationsVersion": "7"
   }
  ]
 },
 "saleInfo": {
  "country": "FR",
  "saleability": "FOR_SALE",
  "isEbook": true,
  "listPrice": {
   "amount": 5.99,
   "currencyCode": "EUR"
  },
  "retailPrice": {
   "amount": 5.99,
   "currencyCode": "EUR"
  },
  "buyLink": "https://play.google.com/store/books/details?id=k7AWCwAAQBAJ&rdid=book-k7AWCwAAQBAJ&rdot=1&source=gbs_api",
  "offers": [
   {
    "finskyOfferType": 1,
    "listPrice": {
     "amountInMicros": 5990000.0,
     "currencyCode": "EUR"
    },
    "retailPrice": {
     "amountInMicros": 5990000.0,
     "currencyCode": "EUR"
    },
    "giftable": true
   }
  ]
 },
 "accessInfo": {
  "country": "FR",
  "viewability": "PARTIAL",
  "embeddable": true,
  "publicDomain": false,
  "textToSpeechPermission": "ALLOWED",
  "epub": {
   "isAvailable": true,
   "acsTokenLink": "http://books.google.fr/books/download/Read_Write_Book_2-sample-epub.acsm?id=k7AWCwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
  },
  "pdf": {
   "isAvailable": true,
   "acsTokenLink": "http://books.google.fr/books/download/Read_Write_Book_2-sample-pdf.acsm?id=k7AWCwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
  },
  "webReaderLink": "http://play.google.com/books/reader?id=k7AWCwAAQBAJ&hl=&printsec=frontcover&source=gbs_api",
  "accessViewStatus": "SAMPLE",
  "quoteSharingAllowed": false
 }

     */

}
