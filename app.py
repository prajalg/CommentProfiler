from flask import Flask, request, jsonify
import pickle
import x
# model = pickle.load(open('finalized_model.pkl', 'rb'))

app = Flask(__name__)



@app.route('/')
def home():
    return "Hello World"


@app.route('/predict', methods=['POST'])
def predict():
    link = request.form.get('link')
    y = x.hi(link)
    jsonify(y)
    return y


if __name__ == '__main__':
    app.run(debug=True)
