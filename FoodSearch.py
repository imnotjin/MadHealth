import requests
import json

# Set up API key and endpoint URLs
API_KEY = 'iozvUIs2rWYXQ2lfItOoCcb3fXc3zMbaHEmR2tgZ'
SEARCH_ENDPOINT = 'https://api.nal.usda.gov/fdc/v1/search'
NUTRITION_ENDPOINT = 'https://api.nal.usda.gov/fdc/v1/{food_id}'

# Get the food item from the user
food_item = input('Enter a food item: ')

# Make a search request to find the FDC ID for the food item
params = {'api_key': API_KEY, 'generalSearchInput': food_item}
response = requests.get(SEARCH_ENDPOINT, params=params)
data = json.loads(response.text)
fdc_id = data['foods'][0]['fdcId']

# Make a nutrition request to obtain the nutritional information for the food item
url = NUTRITION_ENDPOINT.format(food_id=fdc_id)
params = {'api_key': API_KEY}
response = requests.get(url, params=params)
data = json.loads(response.text)

# Extract the relevant nutritional information from the response
nutrients = data['foodNutrients']
sorted_Nutrients = sorted(nutrients, key=lambda d: d['nutrient']['name'])
result = food_item
for i in range(len(nutrients)):
    name = sorted_Nutrients[i]['nutrient']['name']
    value = sorted_Nutrients[i]['amount']
    unit = sorted_Nutrients[i]['nutrient']['unitName']
    result += "," + str(value)

with open("data.txt", "w") as f:
    f.write(result)
